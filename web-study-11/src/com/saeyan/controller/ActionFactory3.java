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

public class ActionFactory3 {
	private static ActionFactory3 instance = new ActionFactory3();

	private ActionFactory3() {
		super();
	}

	public static ActionFactory3 getInstance() {
		return instance;
	}

	// AC 등록
	public Action2 getAction(String uri) {
		///web-study-11/board/reply_add.do
		Action2 action = null;
		System.out.println("ActionFactory3 :" + uri);
		//요청URI에 reply_add.do 커멘드가 포함되면  
		if(uri.contains("reply_add.do")){
			// 부모클레스, 인터페이스 타입의 참조변수는
			//자식클래스객체를 대입받을 수 있다
			action=new BoardReplyAction2();
		}else if(uri.equals("reply_del.do")){
			action=new BoardReplyDelAction2();
		}
		return action;
	}
}
