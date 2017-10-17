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
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//등록폼 이동(forward 사용)
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("product/productWrite.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("product/productWrite.jsp");
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
		int sizeLimit = 20 * 1024 * 1024; //20M
		MultipartRequest multi 
		= new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		//입력모델
		ProductVO pVo = new ProductVO();
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		//파일자체가 아닌 파일의메타 정보(저장경로)를 저장 
		pVo.setPictureUrl(pictureUrl);
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(pVo);
		//출력모델 X 경우 출력뷰 이동(sendRedirect)
		//가급적 서블릿 요청명(URL) 사용
		//response.sendRedirect("productList.do");
		// ProductListServlet의 doPost()호출
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("productList.do");
		dispatcher.forward(request, response);
	}

}
