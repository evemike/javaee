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
<s:iterator value="teachers" var="teacher">
我是其中的一条数据<br />
</s:iterator>
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>用户名</th>
			<th>性别</th>
			<th>邮箱</th>
		</tr>

		<s:iterator value="teachers" var="teacher">
			<tr>
				<td>1</td>
				<td><s:property value="#teacher.name" /></td>
				<td><s:property value="#teacher.username" /></td>
				<td><s:property value="#teacher.sex" /></td>
				<td><s:property value="#teacher.email" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>