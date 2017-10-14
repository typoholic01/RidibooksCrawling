<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/detail.css" />

<!-- body -->
<div class="post-header">
	<div class="row">
		<div class="col-sm-12">
			<h3 style="margin-top:0px">${post.title }</h3>
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
	<div class="row">
		<div class="col-sm-2" style="padding-top: 1em;margin-left: 0.5em;">
			<c:forEach items="${fileList }" var="file">
				<span class="file">
					<i class="fa fa-file" aria-hidden="true"></i>
					<a href="${pageContext.request.contextPath }/upload/file/${file.storedFileName }" download="${file.originalFileName }">${file.originalFileName }</a>
					 (${file.fileKBSize } kb)
				</span>
			</c:forEach>
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
		<div class="col-sm-12 text-right">
			<c:if test="${login.email == post.userId }">
			<!-- 수정 -->
			<form action="./${postSeq }/update" method="GET">
				<button type="submit" class="btn btn-warning btn-xs">수정</button>
			</form>
			<!-- 삭제 -->
			<form action="./${postSeq }?page=${param.page}" method="POST">
				<input type="hidden" name="_method" value="DELETE">
            	<button type="submit" class="btn btn-danger btn-xs">삭제</button>
			</form>
			</c:if>
		</div>
	</div>
</div>