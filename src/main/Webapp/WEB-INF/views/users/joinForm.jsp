<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<form>
	<div class="form-group">
		<label for="username">Username</label>
		<input type="text" class="form-control" placeholder="아이디를 입력해주세요" id="username">
	</div>
	<div class="form-group">
		<label for="email">Email</label>
		<input type="email" class="form-control" placeholder="이메일을 입력해주세요" id="email">
	</div>
	<div class="form-group">
		<label for="pwd">Password</label>
		<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="pwd">
	</div>
	</form>
	<button class="btn btn-primary" id="btn-join">회원가입</button>
</div>
<br>
<script src="/js/user.js"></script>



<%@ include file="../layout/footer.jsp" %>