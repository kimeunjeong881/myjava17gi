package com.saeyan.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.Action2;
import com.saeyan.controller.action.BoardReplyAction2;
import com.saeyan.dto.BoardVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet2")
public class BoardServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// command=board_list
		String command = request.getParameter("command");

		System.out.println("BoardServlet2" + command);
		ActionFactory2 af = ActionFactory2.getInstance();
		// 액션컨트롤러 객체 리턴받음
		Action2 action = af.getAction(command);
		if (action != null) {
			// 액션컨트롤러의 액션메소드 execute 호출
			Map<String, Object> model = new HashMap<String, Object>(); // 100번지
			BoardVO vo = new BoardVO();
			//vo에 글내용(파라미터)을 채움
			//.......
			// model.put("vo", vo);
			model.put("writer", "kim"); // 작성자
			String url = action.execute(model);
			request.setAttribute("model", model);
			// 디버그코드
			System.out.println("model=" + model);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
