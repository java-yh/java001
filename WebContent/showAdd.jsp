<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
	用户名：<input type="text" name="username" id="username"><span></span><br>
	密码	：<input type="password" name="password"id="password"><br>
	<input type="submit" id="submit1" value="注册">
	<input type="button" id="submit2" value="返回">
	</form>
			<script src="./js/jquery-3.1.1.js"></script>
	<script >
	$(function(){
		$('#submit1').click(function(){
			//获取用户输入的用户名
			var username = $("#username").val();
			var password = $("#password").val();
			$.ajax({
				url:'LoginServletAdd',
				type:'post',
				data:{
					"username":username,
					"password":password,
				},
				success:function(data){
					var err = JSON.parse(data);
					if(err=="1"){
						location.href="login.jsp";
					}else{
						location.href="showAdd.jsp";
					}
					
				},
				error:function(){
					
				}
			})	
	})
	})
	$(function(){
			
			$('#submit2').click(function(){
				location.href="login.jsp";
				})
			})
</script >
</body>
</html>