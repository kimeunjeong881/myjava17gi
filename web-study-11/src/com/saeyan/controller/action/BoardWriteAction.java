package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		// boardList.jsp forward하지 않고 BoardListAction의 execute 호출한 이유
		// 최신 정보를 selectAllBoards 통해 조회하기 위해서 서블릿을 거쳐야한다
//		new BoardListAction().execute(request, response);
		
		// FC에게 최신 정보 조회 요청
		response.sendRedirect("BoardServlet?command=board_list");
	}
}
