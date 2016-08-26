<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.Servlet.CheckCustomerServlet,Film.Film,java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增电影</title>
<style type="text/css">
body {
	color: #000;
	font-size: 30px;
	margin: 20px auto;
}
</style>
<script type="text/javascript">
	function check(form) {
		if (document.forms.insertForm.film_id.value == "") {
			alert("请输入电影序号！");
			document.forms.insertForm.film_id.focus();
			return false;
		}
		if (document.forms.insertForm.title.value == "") {
			alert("请输入电影标题！");
			document.forms.insertForm.title.focus();
			return false;
		}
		if (document.forms.insertForm.description.value == "") {
			alert("请输入电影描述！");
			document.forms.insertForm.description.focus();
			return false;
		}
	}
</script>

</head>
<body>
	<form action="<%=request.getContextPath()%>/InsertServlet"
		method="post" name="insertForm">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">新增电影</td>
			</tr>
			<tr>
				<td>电影序号：</td>
				<td><input onkeyup="value=value.replace(/[^\d]/g,'') "
					id="film_id" name="film_id"></td>
			</tr>
			<tr>
				<td>电影标题：</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>电影描述：</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td colspan="2" align="Center"><input type="submit" value="新增"
					onclick="return check(this);" /> <input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>