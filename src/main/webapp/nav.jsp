<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="joinCSS/nav.css">
<script type="text/javascript" src="script/JoinScript.js"></script>
<title>Insert title here</title>
</head>
<body>
<!--이미지 로고 -->
<span class="sidebar">
	<span>
		<a href="BoardServlet?command=main_home">
		<!-- 이미지 주소 -->
		<img src="https://i.ibb.co/1G4LWbz/001.png" alt="001" border="0" class="log">
		</a>
	</span>

<!-- 네비게이션바 -->

	<!-- 왼쪽 네비게이션바 -->
	<span class="list1">
		<li><a href="#">전체</a></li>
		<li><a href="#">세트</a></li>
		<li><a href="#">귀걸이</a></li>
		<li><a href="#">목걸이</a></li>
		<li><a href="#">반지</a></li>
		<li><a href="#">신상</a></li>
		<li><a href="#">베스트</a></li>
		
	</span>
	
	<span class="nav2">
		<span class="list2">
			<li><a href="#">공지사항</a></li>
			<li><a href="#">QnA</a></li>
			<li><a href="#">리뷰</a></li>
		</span>
	</span>
	
</span>
<span class="rightbar">
	<span class="btn">
			<button>장바구니</button>
	</span>
	<span class="list3">
		<li><a href="#">로그인</a></li>
		<li><a href="BoardServlet?command=join_form">회원가입</a></li>
		<li><a href="#">주문내역</a></li>
		<li><a href="#">마이페이지</a></li>
	</span>
</span>

</body>
</html>