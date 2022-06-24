package com.projectA.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectA.dao.UserDAO;
import com.projectA.dto.UserDTO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO uDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "user/loginForm.jsp";
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면
			url = "main.jsp"; // 메인 페이지로 이동한다.
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}//doGet

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  String url = "user/loginForm.jsp";
		  
		  String email = request.getParameter("email"); 
		  String password = request.getParameter("password");
		  
		  UserDAO uDao = UserDAO.getInstance();
		  
		  int result = uDao.userCheck(email,password);
		  
		  if(result == 1) {
		  
		  UserDTO uDto = uDao.selectUser(email); 
		  HttpSession session = request.getSession(); 
		  session.setAttribute("loginUser", uDto);
		  request.setAttribute("message", "회원 가입에 성공했습니다."); 
		  url = "main.jsp";
		  
		  }else if( result == 0) { request.setAttribute("message", "비밀번호가  맞지 않습니다.");
		  
		  }else if(result == -1) { request.setAttribute("message", "존재하지 않는 회원입니다."); }
		  
		  RequestDispatcher dis = request.getRequestDispatcher(url);
		  dis.forward(request, response);
		
		
   /*     if(!loginCheck(email, password)) {
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");

            return "redirect:/login?msg="+msg;
        }
        HttpSession session = request.getSession();
        session.setAttribute("id", email);

        if(rememberId) {
            Cookie cookie = new Cookie("id", email); // ctrl+shift+o 자동 import
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", email); // ctrl+shift+o 자동 import
            cookie.setMaxAge(0); 
            response.addCookie(cookie);
        }
        toURL = toURL==null || toURL.equals("") ? "/" : toURL;

        return "redirect:"+toURL;
    }

    private boolean loginCheck(String email, String password) {
        UserDTO user = null;

        try {
            user = uDao.selectUser(email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return user!=null && user.getPassword().equals(password);
    }	*/
	}//doPost

}