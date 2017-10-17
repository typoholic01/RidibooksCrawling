<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- navbar 선택 스크립트 -->
<script type="text/javascript">
$(document).ready(function() {
	console.log('${requestScope["javax.servlet.forward.request_uri"]}');
	var url = '${requestScope["javax.servlet.forward.request_uri"]}';
	
	if (url.indexOf('/typoholic/news') != -1) {
		$('#myNavbar > ul:nth-child(1) > li:nth-child(2)').attr('class','active');		
	} else if (url.indexOf('/typoholic/free') != -1) {
		$('#myNavbar > ul:nth-child(1) > li:nth-child(3)').attr('class','active');		
	} else if (url.indexOf('/typoholic/book') != -1) {
		$('#myNavbar > ul:nth-child(1) > li:nth-child(4)').attr('class','active');		
	} else if (url.indexOf('/typoholic/') != -1) {
		$('#myNavbar > ul:nth-child(1) > li:nth-child(1)').attr('class','active');
	}	
	
})
</script>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath }/">도서정보</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath }/">Home</a></li>
        <li><a href="${pageContext.request.contextPath }/news">뉴스 게시판</a></li>
        <li><a href="${pageContext.request.contextPath }/free">자유 게시판</a></li>
        <li><a href="${pageContext.request.contextPath }/book">도서 리스트</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<!-- 로그인 X -->
      	<c:if test="${login == null }">
        <li><a href="${pageContext.request.contextPath }/user/login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
        <li><a href="${pageContext.request.contextPath }/user/account"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
        </c:if>
        <!-- 로그인 O -->
        <c:if test="${login != null }">
        	<li><span class="glyphicon glyphicon-user" style="color: silver;"></span> 
        	<a href="${pageContext.request.contextPath }/user/${login.seq }" style="    display: -webkit-inline-box; padding-left: inherit;padding-right: inherit;">${login.nickname }</a> 
        	<span class="text-light" style="color: darkgray;">님 안녕하세요</span>
        	</li>
        	<li><a href="${pageContext.request.contextPath }/user/logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>