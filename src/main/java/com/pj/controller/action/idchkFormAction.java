package com.pj.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.dao.ProjectDAO;

public class idchkFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/join/idChk.jsp";
		
		String userid = request.getParameter("userid");
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		int result = pdao.useID(userid);
		
		request.setAttribute("result", result);
		request.setAttribute("userid", userid);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
