<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath }/">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="${pageContext.request.contextPath }/free/">자유 게시판</a></li>
        <li><a href="${pageContext.request.contextPath }/book/">도서 리스트</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        <li><a href="${pageContext.request.contextPath }/user/account/"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
      </ul>
    </div>
  </div>
</nav>