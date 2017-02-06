<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理--编辑</title>
</head>
<body>
	<form action="update" method="post">
		<input type="hidden" name="teacherId"
			value="<s:property value="teacher.teacherId" />" />
		<s:textfield label="姓名：" name="name" />
		<br />
		<s:textfield label="用户名：" name="username" />
		<br /> 性别：<select name="sex">
			<option value="0">男</option>
			<option value="1">女</option>
		</select> <br /> <s:textfield label="邮箱：" name="email" /><br /> <s:textfield label="密码：" name="password" /><br />
		<button type="submit">submit</button>
	</form>
</body>
</html>