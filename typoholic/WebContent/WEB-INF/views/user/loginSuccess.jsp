<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row main col-sm-12">
		<h1 class="text-success text-center">로그인에 성공하셨습니다!</h1>	
		<form action="${pageContext.request.contextPath }" style="text-align: -webkit-center;">
		<button type="submit" class="btn btn-success" >메인으로</button>
		</form>
	</div>
</div>