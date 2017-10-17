package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardReplyDAO;

public class BoardReplyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. JDBC 로직코드는 BoardReplyDAO로 분리후 연동
		//System.out.println("board 테이블에 1번글의 답글 추가");
		BoardReplyDAO dao= new BoardReplyDAO();
		String res= dao.insertReply();
		//2. 비JDBC 로직코드(로그)
		System.out.println("답글완료");
		//3. 비JDBC 로직코드(이동)
		String url = "/board/boardReplyList.jsp";//출력뷰
		request.setAttribute("res", res);
		////출력뷰 이동
		RequestDispatcher dispatcher 
		= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
