<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
/* CSS talk bubble */
.talk-bubble {
  display: inline-block;
  position: relative;
	height: auto;
    border: 1px solid lightgray;
}
.border{
  border: 8px solid #666;
}
.round{
  border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;

}

/* talk bubble contents */
.talktext{
  padding: 1em;
	text-align: left;
  line-height: 1.5em;
}
.talktext p{
  /* remove webkit p margins */
  -webkit-margin-before: 0em;
  -webkit-margin-after: 0em;
}
</style>

<!-- comment -->
<div class="row">
	<div class="col-sm-12">
	<h3>댓글</h3>
	</div><!-- /col-sm-12 -->
</div><!-- /row -->
<div class="comment-box">
	<!-- 댓글 -->
	<div class="comment">
		<div class="row">
			<div class="col-sm-10">
				<div class="col-sm-2">
					<div class="thumbnail col-sm-8">
						<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>				
				</div>
				<div class="col-sm-10">
					<div class="row">
						<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
					</div>
					<div class="row">
						<div class="talk-bubble round">
						  <div class="talktext">
						    <p>This talk-bubble uses .left-in class to show a triangle on the left slightly indented. Still a blocky square.</p>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 대댓글 -->
	<div class="comment">
		<div class="row">
			<div class="col-sm-10">
				<div class="col-sm-2">
					<div class="col-sm-4">
						<i class="material-icons">subdirectory_arrow_right</i>					
					</div>
					<div class="thumbnail col-sm-8">
						<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>				
				</div>
				<div class="col-sm-10">
					<div class="row">
						<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
					</div>
					<div class="row">
						<div class="talk-bubble round">
						  <div class="talktext">
						    <p>This talk-bubble uses .left-in class to show a triangle on the left slightly indented. Still a blocky square.</p>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 댓글 등록 -->
<div class="row">
	<div class="col-md-3 col-sm-offset-2">
		<h3>댓글 쓰기</h3>	
	</div>
</div>   
<div class="row">   
	<div class="col-sm-8 col-sm-offset-2">
		<form>
		<div class="panel panel-default">
				<div class="panel-heading">
					<strong>myusername</strong> <span class="text-muted">commented 5 days ago</span>
				</div>
				<div class="panel-body" style="padding: inherit;">
					<textarea placeholder="글쓴이는 댓글이 필요해요!" ></textarea>				
				</div>
				<div class="panel-footer" style="text-align: -webkit-right;">				
					<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> 등록</button>
				</div>
		</div><!-- Status Upload  -->
		</form>
	</div>       
</div>