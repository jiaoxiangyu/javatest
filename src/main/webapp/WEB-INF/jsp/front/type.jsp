<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import  url="head.jsp"/>
	<a href="${rootPath}front/index"><< 返回试题集</a>
	<table align="center">
		<tr>
			<td>试题编号</td>
			<td>试题名称</td>
			<td>关键字</td>
			<td>更新时间</td>
			<td>试题状态</td>
			<td>进入试题</td>
			<td>提交记录</td>
		</tr> 
		<c:forEach items="${questions}" var="q">
	 		<tr>
				<td>${q.id }</td>
				<td>${q.name }</td>
				<td>${q.keyword }</td>
				<td>${q.createDate }</td>
				<td>${q.status }</td>
				<td><a href="${rootPath}front/toQuestion?qtId=${q.id}">进入试题</a></td>
				<td><a href="${rootPath}front/submitHistory?qtId=${q.id}">提交记录</a></td>
			</tr> 
		</c:forEach>
	</table>
	${msg }
</body>
</html>