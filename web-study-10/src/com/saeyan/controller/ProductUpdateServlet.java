package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO pVo = pDao.selectProductByCode(code);
		request.setAttribute("product", pVo);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024; // 1M
		
		// 파일업로드 클래스
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		// 수정 이미지 경로
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		// 이미지가 바뀌지 않았다면 기존 이미지 경로 저장
		if (pictureUrl == null) {
			// 기존 이미지 경로
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		ProductVO pVo = new ProductVO();
		pVo.setCode(Integer.parseInt(code));
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.updateProduct(pVo);

		// productList.do 호출하면
		// get 방식으로 전송
		response.sendRedirect("productList.do");
		
		/*
		2. request 영역에 모델 저장
		request.setAttribute("productList", productList);
		3. 리스트 출력뷰 forward 자동이동
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("product/productList.jsp");
		dispatcher.forward(request, response);
		 */
		// productList.do 호출하면
		// ProductList의 doGet()호출
		// 수정된 최신DB의 상품리스트를
		// 조회함
		// get 방식으로 전송
		// response.sendRedirect("productList.do");
		// post 방식으로 전송
		/*RequestDispatcher dispatcher = request
				.getRequestDispatcher("productList.do");
		dispatcher.forward(request, response);*/

	}

}
