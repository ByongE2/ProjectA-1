package com.pj.controller;

import com.pj.controller.action.Action;
import com.pj.controller.action.idchkFormAction;
import com.pj.controller.action.joinAction;
import com.pj.controller.action.joinFormAction;
import com.pj.controller.action.mainAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		if(command.equals("join_form")) {
			action = new joinFormAction();
		}else if(command.equals("join_Member")) {
			action = new joinAction();
		}else if(command.equals("idchk")) {
			action =  new idchkFormAction();
		}else if(command.equals("main_home")) {
			action = new mainAction();
		}
		
		
		return action;
		
	}
}
