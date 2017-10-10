<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

//확인
function confirmPassword() {
	//값 가져오기
	var password = $("#password input[name=password]").val();
	var confirm = $("#confirm input[name=confirm]").val();
	
	//값을 입력한 경우에만 출력
	if (password.length > 0 && confirm.length > 0) {
		//일치할 경우
		if (password == confirm) {
			$("#password").attr("class","form-group has-success has-feedback");
			$("#confirm").attr("class","form-group has-success has-feedback");
			
			$("#password span.glyphicon").attr("class","glyphicon glyphicon-ok form-control-feedback");
			$("#confirm span.glyphicon").attr("class","glyphicon glyphicon-ok form-control-feedback");
			
			$("#password span.glyphicon").css("display","block");
			$("#confirm span.glyphicon").css("display","block");
			
		//불일치할 경우
		} else {
			$("#password").attr("class","form-group has-error has-feedback");
			$("#confirm").attr("class","form-group has-error has-feedback");

			$("#password span.glyphicon").attr("class","glyphicon glyphicon-remove form-control-feedback");
			$("#confirm span.glyphicon").attr("class","glyphicon glyphicon-remove form-control-feedback");
			
			$("#password span.glyphicon").css("display","block");
			$("#confirm span.glyphicon").css("display","block");
		}
	//값 입력이 빠진 경우
	} else {
		if (password.length == 0) {
			$("#password").attr("class","form-group");
			$("#password span.glyphicon").css("display","none");
			
		} 
		
		if (confirm.length == 0) {
			$("#confirm").attr("class","form-group");
			$("#confirm span.glyphicon").css("display","none");

		}
	}
}

</script>

<div class="container">
	<div class="row main col-sm-4 col-sm-offset-4">
		<div class="panel-heading">
              <div class="panel-title text-center">
              		<h1 class="title">활자중독</h1>
              		<hr />
              	</div>
           </div> 
		<div class="main-login main-center">
			<form class="form-horizontal" method="post" action="./">

				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">이메일</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">별명</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="name" id="name" placeholder="Enter your Name"/>
						</div>
					</div>
				</div>

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

				<div id="confirm" class="form-group">
					<label for="confirm" class="cols-sm-2 control-label">비밀번호 확인</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input onblur="confirmPassword();" type="password" class="form-control" name="confirm" placeholder="Confirm your Password"/>
							<span class="glyphicon glyphicon-ok form-control-feedback" style="display: none;"></span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block login-button">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>