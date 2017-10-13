<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Resources -->
<%@ include file="head.jsp" %>

<!-- body -->
<div class="row">
<div class="col-sm-12">
<header class="post-header">
	<h3>${post.title }</h3>
	<div class="post-author">
		<i class="fa fa-user"></i><span>${post.userId }</span>
	</div>
	<div class="post-info">
		<span class="date"><i class="fa fa-clock-o"></i> 2017-10-13 00:54:12</span>
		<span class="hit"><i class="fa fa-eye"></i> 99</span>
	</div>
</header>
<article class="post-content">
	<div class="post-content-inner" id="post-content-inner">
		${post.content }
	</div>									
</article>
</div>
</div>

<!-- comments -->
<%@ include file="comment.jsp" %>