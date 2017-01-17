<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理--新增</title>
</head>
<body>
	<form action="save" method="post">
		<s:textfield label="姓名：" name="name" />
		<br />
		<s:textfield label="用户名：" name="username" />
		<br /> 性别：<select name="sex">
			<option value="0">男</option>
			<option value="1">女</option>
		</select> <br /> 邮箱：<input type="text" name="email" /><br /> 密码：<input
			type="password" name="password" /><br />
		<button type="submit">submit</button>
	</form>
</body>
</html>