<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row main col-sm-4 col-sm-offset-4">
		<div class="panel-heading">
              <div class="panel-title text-center">
              		<h1 class="title">활자중독</h1>
              		<hr />
              	</div>
           </div> 
		<div class="main-login main-center">
			<form class="form-horizontal" method="POST" action="./login">
			
				<!-- 이메일 -->
				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">이메일</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
						</div>
					</div>
				</div>
				
				<!-- 비밀번호 -->
				<div id="password" class="form-group">
					<label for="password" class="cols-sm-2 control-label">비밀번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input onblur="confirmPassword();" type="password" class="form-control" name="password" placeholder="Enter your Password"/>
							<span class="glyphicon glyphicon-ok form-control-feedback" style="display: none;"></span>
						</div>
					</div>
				</div>
				
				<!-- 버튼 -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block login-button">로그인</button>
				</div>
			</form>
		</div>
	</div>
</div>