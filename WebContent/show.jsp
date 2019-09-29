<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellspacing="0" cellpadding="5px" border="1" align="center" width="50%">
		<tr>
			<th>产品编号</th>
			<th>产品名称</th>
			<th>产品价格</th>
			<th>产品产地</th>
			<th>产品样图</th>
		</tr>
	</table>
	<input type="submit" id="submit" value="返回">
	<script src="./js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#submit').click(function() {
		window.location.href = "login.jsp";
		})
	})
	window.onload=function(){
		$.ajax({
			url:"loginServlet?type=show",
			type:'post',
			data:{},
			dataType:'text',
			success:function(data){
				console.log(data);
				var arr = JSON.parse(data);
				console.log(arr);
				//i 下标 e 对象
				$.each(arr,function(i,e){
					$('table').append("<tr><td>"+e.proid+"</td><td>"+e.proname+"</td><td>"+e.proprice+"</td><td>"+e.proaddress+"</td><td>"+e.proimage+"</td></tr>");
				})
			},
			error:function(data){
			
			}
		})
	}
	</script>
</body>
</html>