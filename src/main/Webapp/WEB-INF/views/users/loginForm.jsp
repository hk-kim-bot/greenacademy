<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<form action="/auth/loginProc" method="POST">
	<div class="form-group">
		<label for="username">Username</label>
		<input type="text" class="form-control" placeholder="아이디를 입력해주세요" id="username"name="username">
	</div>
	
	<div class="form-group">
		<label for="pwd">Password</label>
		<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="pwd" name="password">
	</div>
	<div class="form-group form-check">
		<label class="form-check-label">
			<input type="checkbox" class="form-check-input" name="remember">Remember Me
		</label>
	</div>
	
	<button type="submit" class="btn btn-primary" id="btn-login">로그인</button>
	</form>
</div>
<br>
<!--  <script src="/js/user.js"></script>-->



<%@ include file="../layout/footer.jsp" %>