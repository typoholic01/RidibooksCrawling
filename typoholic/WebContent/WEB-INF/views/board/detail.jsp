<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Resources -->
<%@ include file="head.jsp" %>

<style>
.post-header {
	padding: 10px;
	border: 1px solid lightgray;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    background-color: #eee;
}
.post-body {
	padding: 10px;
    border-left: 1px solid lightgray;
    border-right: 1px solid lightgray;
}
.post-footer {
	padding: 10px;
    border: 1px solid lightgray;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    background-color: #eee;
}
</style>

<!-- body -->
<div class="post-header">
	<div class="row">
		<div class="col-sm-12">
			<h3>${post.title }</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			<i class="fa fa-user"></i><span>${post.userId }</span>
		</div>
		<div class="col-sm-4 col-sm-offset-4 text-right">
			<span class="date" style="margin-right: 1em;"><i class="fa fa-clock-o"></i> ${post.createAt } </span>
			<span class="hit"><i class="fa fa-eye"></i> 99</span>
		</div>
	</div>
</div>
<div class="post-body">
	<div class="row">
		<div class="col-sm-12">
			<div class="post-content-inner" id="post-content-inner">
				${post.content }
			</div>	
		</div>
	</div>
</div>
<div class="post-footer">
	<div class="row">
		<div class="col-sm-12">
			<div class="post-content-inner" id="post-content-inner">
				버튼 목록
			</div>	
		</div>
	</div>
</div>
<!-- comments -->
<%@ include file="comment.jsp" %>