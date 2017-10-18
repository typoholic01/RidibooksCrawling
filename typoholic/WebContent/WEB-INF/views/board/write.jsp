<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- head -->
<link rel="stylesheet" href='${pageContext.request.contextPath }/resources/css/write.css' />

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<!-- include summernote-ko-KR -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/lang/summernote-ko-KR.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	  $('#summernote').summernote({
		  height: 200,                 // set editor height
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  focus: true,                 // set focus to editable area after initializing summernote
		  lang : 'ko-KR',				// 기본 메뉴언어 US->KR로 변경
		  callbacks: {
	          onImageUpload: function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	              sendFile(files[i], this);
	            }
	          }
	        }
		});
	});

function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '${pageContext.request.contextPath }/file/image',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(url) {
    	  console.log(url);
        $(el).summernote('editor.insertImage', url);
        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
      }
    });
}
</script>
<script type="text/javascript">
<!--
	글쓰기
//-->
function bbsWrite() {
	var content = $('#summernote').summernote("code");

	$('#content').val(content);
	
	$('#postWrite').submit();
}
</script>

<form id="postWrite" action="./write" method="POST">
<input type="hidden" id="content" name="content" value="" />
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="form-group"> <!-- userId field -->
				<label class="control-label " for="userId">아이디</label>
				<input class="form-control" id="userId" name="userId" type="text" value="${login.email }" readonly="readonly"/>
			</div>
			
			<div class="form-group"> <!-- "title" field -->
				<label class="control-label " for="title">제목</label>
				<input class="form-control" id="title" name="title" type="text"/>
			</div>
			
			<div class="form-group"> <!-- content field -->
				<label class="control-label " for="content">내용</label>
				<div id="summernote"></div>
			</div>
			
			<div class="form-group pull-right">
				<button class="btn btn-primary " name="button" type="button" onclick="bbsWrite();">글쓰기</button>
			</div>
			
		</div>
	</div>
</form>