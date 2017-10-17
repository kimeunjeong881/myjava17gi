package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

//
public class BoardListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/board/boardList.jsp"; // 1. 뷰페이지 경로
		BoardDAO bDao = BoardDAO.getInstance(); // 2. DAO 생성
		// 3. DAO 데이터처리메소드 호출 selectAllBoards()
		// 결과모델 List<BoardVO> boardList
		List<BoardVO> boardList = bDao.selectAllBoards();
		// 4. 결과모델 request 저장
		request.setAttribute("boardList", boardList);
		// 5. FC에 리턴값 X 뷰페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
