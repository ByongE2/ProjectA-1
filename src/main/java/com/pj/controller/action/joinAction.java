package com.pj.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.dao.ProjectDAO;
import com.pj.dto.ProjectVO;

public class joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/index.jsp";
		
		ProjectVO pvo = new ProjectVO();
		
		pvo.setUserid(request.getParameter("userid"));
		pvo.setPwd(request.getParameter("pwd"));
		pvo.setName(request.getParameter("name"));
		pvo.setPhone(request.getParameter("phone"));
		pvo.setEmail(request.getParameter("email"));
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		pdao.JoinMember(pvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
