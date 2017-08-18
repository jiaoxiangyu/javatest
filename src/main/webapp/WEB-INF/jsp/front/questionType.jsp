<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题集</title>
</head>
<body>
	<c:import  url="head.jsp"/>
	<table align="center" style="margin-top: 50px;">
		<tr>
			<td>试题集名称</td>
			<td>试题总数</td>
			<td>已解决数量</td>
			<td>更新时间</td>
			<td>进入试题集</td>
		</tr>
		
		<c:forEach items="${types}" var="t">
			<tr>
				<td>${t.name}</td>
				<td>${t.qtNum }</td>
				<td>${t.solvedNum }</td>
				<td>${t.updateDate }</td>
				<td><a href="${rootPath}front/toType?typeId=${t.id}">进入试题集</a></td>
			</tr>
		</c:forEach>
		
	</table>
	${msg }
</body>
</html>