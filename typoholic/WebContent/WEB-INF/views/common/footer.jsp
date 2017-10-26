<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.museo_sans {
    font-family: museo_sans,'Apple SD Gothic Neo',Helvetica,arial,'나눔고딕','Nanum Gothic','돋움',Dotum,Tahoma,Geneva,sans-serif;
    font-size: 1.2em;
    padding-right: 1px;
    font-weight: 700;
    cursor: default;
}
.bootstrap-logo {
	color: #7952b3;
    cursor: default;
}
.summernote-logo {
    background-color: yellowgreen;
}
.contact div i {
    text-align: center;
    width: 10%;
}
</style>
<footer class="container">
<div class="row">
	<div class="col-sm-5 contact">
		<div class="phone">
			<i class="fa fa-mobile" style="font-size: x-large;" aria-hidden="true"></i>
			<span class="museo_sans">010-2265-4988</span>			
		</div>
		<div class="email">
			<i class="fa fa-envelope" style="font-size: large;" aria-hidden="true"></i>
			<span class="museo_sans">typoholic01@gmail.com</span>	
		</div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-6 contribute">
		<div class="logos">
			<img class="col-sm-2" alt="bootstrap" src="${pageContext.request.contextPath }/resources/img/bootstrap-logo.png">
			<img class="col-sm-2" alt="JQuery" src="${pageContext.request.contextPath }/resources/img/1280px-JQuery_logo.png">
			<img class="col-sm-2" alt="FontAwesome" src="${pageContext.request.contextPath }/resources/img/font-awesome-card.png">
			<img class="col-sm-3 summernote-logo" alt="Summernote" src="${pageContext.request.contextPath }/resources/img/summernote-logo.png">
		</div>
	</div>
</div>
</footer>