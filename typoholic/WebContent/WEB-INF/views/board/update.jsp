<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="../${postSeq }" method="POST">
	<input type="hidden" name="_method" value="PUT">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="form-group"> <!-- userId field -->
				<label class="control-label " for="userId">아이디</label>
				<input class="form-control" id="userId" name="userId" type="text" value="${post.userId }" readonly="readonly"/>
			</div>
			
			<div class="form-group"> <!-- "title" field -->
				<label class="control-label " for="title">제목</label>
				<input class="form-control" id="title" name="title" type="text" value="${post.title }"/>
			</div>
			
			<div class="form-group"> <!-- content field -->
				<label class="control-label " for="content">내용</label>
				<textarea class="form-control" cols="40" id="content" name="content" rows="10">${post.content }</textarea>
			</div>
			
			<div class="form-group"> <!-- File field -->
			   <input type="file" id="uploadFile" name="uploadFile" class="file" style="visibility: hidden;position: absolute;">
			   <div class="input-group col-xs-12">
			     <span class="input-group-addon"><i class="fa fa-file"></i></span>
			     <input type="text" class="form-control input-lg" disabled placeholder="파일 업로드">
			     <span class="input-group-btn">
			       <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> 파일</button>
			     </span>
			   </div>
			</div>
			
			<div class="form-group pull-right">
				<button class="btn btn-primary " name="submit" type="submit">글쓰기</button>
			</div>
			
		</div>
	</div>
</form>