package com.projectA.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class LogoutController {

	 public String logout(HttpSession session) {
	        // 1. 세션을 종료
	        session.invalidate();
	        // 2. 홈으로 이동
	        return "redirect:/main";
	    }
}
