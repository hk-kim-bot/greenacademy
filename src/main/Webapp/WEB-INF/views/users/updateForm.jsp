<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<form>
	<input type="hidden" id="id" value="${principal.user.id }">
	<div class="form-group">
		<label for="username">Username</label>
		<input type="text" class="form-control" value="${principal.user.username }" readonly 
		placeholder="아이디를 입력해주세요" id="username">
	</div>
	<div class="form-group">
		<label for="email">Email</label>
		<input type="email" class="form-control" value="${principal.user.email }"
		 placeholder="이메일을 입력해주세요" id="email">
	</div>
	<div class="form-group">
		<label for="pwd">Password</label>
		<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="pwd">
	</div>
	</form>
	<button id="btn-update" class="btn btn-primary" id="btn-join">회원수정완료</button>
</div>
<br>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>