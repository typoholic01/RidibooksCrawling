<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Resources -->
<%@ include file="head.jsp" %>

<!-- body -->
<div class="post-head" style="padding: 10px;border-top: 1px solid lightgray;border-bottom: 1px solid lightgray;">
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
			<span class="date" style="margin-right: 1em;"><i class="fa fa-clock-o"></i> 2017-10-13 00:54:12 </span>
			<span class="hit"><i class="fa fa-eye"></i> 99</span>
		</div>
	</div>
</div>
<div class="post-body" style="padding: 10px;border-bottom: 1px solid lightgray;">
	<div class="row">
		<div class="col-sm-12">
			<div class="post-content-inner" id="post-content-inner">
				${post.content }
			</div>	
		</div>
	</div>
</div>
<!-- comments -->
<%@ include file="comment.jsp" %>