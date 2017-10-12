<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row main col-sm-12">
		<h1 class="text-primary text-center">로그인을 해 주세요</h1>	
		<form action="${pageContext.request.contextPath }/user/login" style="text-align: -webkit-center;">
		<button type="submit" class="btn btn-info" >로그인</button>
		</form>
	</div>
</div>