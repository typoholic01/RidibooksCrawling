<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/BScomment.css" />
<script type="text/javascript">
/*****************************  
 *			댓글 입력
 *****************************/
function commentWriteForm() {
	//form데이터 전송
	var params = $('#commentWriteForm').serialize();
	
	$.ajax({
		type: 'POST',
		url: './${postSeq}/comment',
		data: params,
		async: true, 
		success: function(data) {
			getCommentList();
		}	
	});
}

/*****************************  
 *			댓글 출력
 *****************************/
$(document).ready(function() {
	getCommentList();
});
function getCommentList() {
	//댓글 초기화
	$('#comment-box').empty();
	
	//페이지 초기화
	var page = '${page}';
	if (page == '') {
		page = '1';
	}
	
	$.ajax({
		type: 'GET',
		url: './${postSeq}/comment',
		data: {
			"page" : page
		},
		async: true, 
		success: function(data) {			
 			$.each(data.commentList, function(index, item) {
  				//댓글 만들기
  				$('#comment-box').prepend(setCommentHtml(data.commentList[index]));
			}); 
		}	
	});
	
}
function setCommentHtml(comment) {
	var html = '<div class="comment">'
	+'		<div class="row">'
	+'	<div class="col-sm-12">'
	+'		<div class="col-sm-2">'
	+'			<div class="thumbnail col-sm-6">'
	+'				<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">'
	+'			</div>				'
	+'		</div>'
	+'		<div class="col-sm-10">'
	+'			<div class="row">'
	+'				<strong>'+comment.userId+'</strong> <span class="text-muted">'+comment.createAt+'</span>'
	+'			</div>'
	+'			<div class="row">'
	+'				<div class="comment-body">'
	+'				  <div class="comment-text">'
	+'				    <p>'+comment.content+'</p>'
	+'				  </div>'
	+'				</div>'
	+'			</div>'
	+'		</div>'
	+'	</div>'
	+'</div>'
	+'</div>';
	
	return html;
}

/*****************************  
 *			Util
 *****************************/
 
/* textarea 사이즈 조절 */
function resize(obj) {
  obj.style.height = "1px";
  obj.style.height = (12+obj.scrollHeight)+"px";
}
</script>

<!-- comment -->
<div class="row">
	<div class="col-sm-12">
	<h3>댓글</h3>
	</div><!-- /col-sm-12 -->
</div><!-- /row -->
<div id="comment-box" class="comment-box">
	<!-- <!-- 댓글
	<div class="comment">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2">
					<div class="thumbnail col-sm-6">
						<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>				
				</div>
				<div class="col-sm-10">
					<div class="row">
						<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
					</div>
					<div class="row">
						<div class="comment-body">
						  <div class="comment-text">
						    <p>This talk-bubble uses .left-in class to show a triangle on the left slightly indented. Still a blocky square.</p>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	대댓글
	<div class="comment">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2">
					<div class="col-sm-3">
						<i class="material-icons">subdirectory_arrow_right</i>					
					</div>
					<div class="thumbnail col-sm-6">
						<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>				
				</div>
				<div class="col-sm-10">
					<div class="row">
						<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
					</div>
					<div class="row">
						<div class="comment-body">
						  <div class="comment-text">
						    <p>This talk-bubble uses .left-in class to show a triangle on the left slightly indented. Still a blocky square.</p>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>-->
</div>
<c:if test="${login != null }">
<!-- 댓글 등록 -->
<div class="row">
	<div class="col-md-3">
		<h3>댓글 쓰기</h3>	
	</div>
</div>
<div class="row">   
	<div class="col-sm-12">
		<form id="commentWriteForm" method="POST">
		<input name="userId" type="hidden" value="${login.email }">
		<div id="commentWrite" class="panel panel-default">
				<div class="panel-heading">
					<strong>${login.email }</strong>
				</div>
				<div class="panel-body" style="padding: inherit;">
					<textarea name="content" placeholder="글쓴이는 댓글이 필요해요!" onkeydown="resize(this)" onkeyup="resize(this)"></textarea>				
				</div>
				<div class="panel-footer" style="text-align: -webkit-right;">				
					<button type="button" class="btn btn-success green" onclick="commentWriteForm();"><i class="fa fa-share"></i> 등록</button>
				</div>
		</div><!-- Status Upload  -->
		</form>
	</div>       
</div>
</c:if>