function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";		  
    oScript.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js";	
    document.getElementsByTagName("head")[0].appendChild(oScript);
}

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