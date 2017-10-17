package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.Action2;
import com.saeyan.controller.action.BoardCheckPassAction;
import com.saeyan.controller.action.BoardCheckPassFormAction;
import com.saeyan.controller.action.BoardDeleteAction;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.controller.action.BoardReplyAction;
import com.saeyan.controller.action.BoardReplyAction2;
import com.saeyan.controller.action.BoardReplyDelAction2;
import com.saeyan.controller.action.BoardUpdateAction;
import com.saeyan.controller.action.BoardUpdateFormAction;
import com.saeyan.controller.action.BoardViewAction;
import com.saeyan.controller.action.BoardWriteAction;
import com.saeyan.controller.action.BoardWriteFormAction;

public class ActionFactory2 {
	private static ActionFactory2 instance = new ActionFactory2();

	private ActionFactory2() {
		super();
	}

	public static ActionFactory2 getInstance() {
		return instance;
	}

	// AC 등록
	public Action2 getAction(String command) {
		Action2 action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("board_reply")){
			// 부모클레스, 인터페이스 타입의 참조변수는
			//자식클래스객체를 대입받을 수 있다
			action=new BoardReplyAction2();
		}else if(command.equals("board_reply_del")){
			action=new BoardReplyDelAction2();
		}
		return action;
	}
}
