<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<style type="text/css">
body{
	color:#00;
	font-size:14;
	margin:20px auto;
}
</style>
<script type="text/javascript">
	function check(form){
		if(document.forms.loginForm.userName.value==""){
			alter("请输入用户名");
			document.forms.loginForm.userName.focus();
		}
		if(document.forms.loginForm.password.value==""){
			alter("请输入密码");
			document.forms.loginForm.password.focus();
		}
	}
</script>
</head>
<body>
<h2>this is login interface </h2>

	<form action="<%=request.getContextPath()%>/CheckServlet" method="post" name="loginForm">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户登陆 <td/>
			</tr>
			<tr>
				<td>用户名： </td>
				<td> <input type="text" name="userName"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" onclick="return check(this);">
					<input type="reset" name="reset">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>