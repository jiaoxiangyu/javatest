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
	<table>
		<tr>
			<td>提交序号</td>
			<td>用户名</td>
			<td>试题名称</td>
			<td>提交时间 </td>
			<td>评估结果</td>
			<td>得分</td>
			<td>评测详情</td>			
		</tr>
		<c:forEach items="${responses}" var="r">
			<tr>
				<td>${r.id }</td>
				<td>${r.userName }</td>
				<td>${r.qtName }</td>
				<td>${r.writeDate } </td>
				<td>${r.status }</td>
				<td>${r.score }</td>
				<td><a href="${rootPath}front/toDetails?resId=${r.id}">评测详情</a></td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>