<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证错误</title>
</head>
<body>
	<h2>验证错误</h2>
	<ul>
		<!-- 循环输出字段验证发生的错误 -->
		<s:iterator value="fieldErrors" var="fieldError">
			<li><s:property /></li>
		</s:iterator>
	</ul>

	<!-- 使用struts内置标题输出字段，将自动带入出错信息 -->
	<s:textfield label="姓名：" name="name" />
	<br />
	<s:textfield label="用户名：" name="username" />
</body>
</html>