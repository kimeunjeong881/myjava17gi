package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = ProductDAO.getInstance();
		//1. 리스트 출력뷰에게 전달할 모델(List<ProductVO>)을 생성
		List<ProductVO> productList = pDao.selectAllProducts();
		//2. request 영역에 모델 저장
		request.setAttribute("productList", productList);
		//3. 리스트 출력뷰 forward 자동이동
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("product/productList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
