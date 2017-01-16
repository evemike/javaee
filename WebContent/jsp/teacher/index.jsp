<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
</head>
<body>
	<h2>
		输入的关键字为:<s:property value="name" />
	</h2>
	<form method="GET">
		<label>姓名：<input type="text" name="name" value="<s:property value="name" />" /></label>
		<button type="submit">submit</button>
	</form>
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>用户名</th>
			<th>性别</th>
			<th>邮箱</th>
		</tr>
		<!-- s为我们在文件头定位的标签前缀。iterator是struts用于循环输出List的标签 -->
		<!-- teachers：自动调用C层的getTeachers()；var=teacher：在循环体中使用的变量名 -->
		<s:iterator value="teachers" var="teacher" status="status">
			<tr>
				<td><s:property value="#status.count" /></td>
				<!-- property输出变量 teacher为内部变量，前面加入# -->
				<td><s:property value="#teacher.name" /></td>
				<td><s:property value="#teacher.username" /></td>
				<td><s:property value="#teacher.sexAttr" /></td>
				<td><s:property value="#teacher.email" /></td>
			</tr>
		</s:iterator>
	</table>
	<h4>
		每页1条：<a href="?page=1&pageSize=1">1</a> <a href="?page=2&pageSize=1">2</a>
		<a href="?page=3&pageSize=1">3</a><br /> 每页2条：<a
			href="?page=1&pageSize=2">1</a> <a href="?page=2&pageSize=2">2</a> <a
			href="?page=3&pageSize=2">3</a><br /> 每页3条：<a
			href="?page=1&pageSize=3">1</a> <a href="?page=2&pageSize=3">2</a> <a
			href="?page=3&pageSize=3">3</a><br />
	</h4>

</body>
</html>