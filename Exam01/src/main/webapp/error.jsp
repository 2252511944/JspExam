<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
<style type="text/css">
body{
	color:#00;
	font-size:14;
	margin:20px auto;
}
#message{
	text-align:center;
}
</style>
</head>
<body>
	<div id="message">
		<h2>错误页面</h2>
		登陆失败<br>
		错误提示：
		<%
			Object obj = request.getAttribute("msg");
			if(obj != null){
				out.println(obj.toString());
			}else{
				out.print("无");
			}
		%>
		您提交的信息为：<br>
		用户名：<%=request.getParameter("userName") %>
		<a href="<%=request.getContextPath()%>/login.jsp">返回登陆页面</a>
	</div>
</body>
</html>