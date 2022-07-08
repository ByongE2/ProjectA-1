package com.projectA.controller;

import java.io.IOException;

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

@WebServlet("/login2")
public class LoginController_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO uDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "loginForm.jsp";
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면
			url = "main.jsp"; // 메인 페이지로 이동한다.
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}//doGet

	public void doPost(boolean rememberId, String toURL, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  String url = "loginForm.jsp";
		  
		  String email = request.getParameter("email"); 
		  String password = request.getParameter("password");
		  
		  UserDAO uDao = UserDAO.getInstance();
		  
		  int result = uDao.userCheck(email,password);
		  
		  if(result == 1) {
		  
		  UserDTO uDto = uDao.selectUser(email); 
		// 2-2. id와 pwd가 일치하면,
	        //  세션 객체를 얻어오기
	        HttpSession session = request.getSession();
	        //  세션 객체에 id를 저장
	        session.setAttribute("loginUser", uDto);

	        if(rememberId) {
	            //     1. 쿠키를 생성
	            Cookie cookie = new Cookie("loginUser", email); // ctrl+shift+o 자동 import
//			       2. 응답에 저장
	            response.addCookie(cookie);
	        } else {
	            // 1. 쿠키를 삭제
	            Cookie cookie = new Cookie("loginUser", email); // ctrl+shift+o 자동 import
	            cookie.setMaxAge(0); // 쿠키를 삭제
//			       2. 응답에 저장
	            response.addCookie(cookie);
	        }
		  
	        toURL = toURL==null || toURL.equals("") ? "/" : toURL;

	        response.sendRedirect(url);
		  
		  }else if( result == 0) { request.setAttribute("message", "비밀번호가  맞지 않습니다.");
		  
		  }else if(result == -1) { request.setAttribute("message", "존재하지 않는 회원입니다."); }
		  
//		  RequestDispatcher dis = request.getRequestDispatcher(url);
//		  dis.forward(request, response);
		  response.sendRedirect(url);
		
		
   /*     if(!loginCheck(email, password)) {
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");

            return "redirect:/login?msg="+msg;
        }
        HttpSession session = request.getSession();						//세션에 id 추가하고. 
        																//나중에 로그인체크로는 세션에 id가 있으면 로그인상태, 아니면 아닌상태
        															 	//왜냐면 세션이 없다는것은, 로그아웃(invalidate)했거나 세션만료기간 끝
        															 	//세션은 서버에 저장하고 쿠키에 담아서 매번 새롭게 응답해주는데
        															 	//여기에 세션 key값 id에 value값 담아서주면. 로그인상태인거임. 없으면 아닌거고. 
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