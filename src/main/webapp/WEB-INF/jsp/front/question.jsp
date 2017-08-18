<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import  url="head.jsp"/>
	<a href="${rootPath}front/toType?typeId=${question.typeId}"><< 返回</a>
	<h3 align="center">${question.name}</h3>
	<p align="center">时间限制：1.0s 内存限制：256M<p>

	<p>${question.content}</p>
	<form action="${rootPath}front/toSubmit?qtId=${question.typeId}" method="post">
		编译语言：Java<br>
		<textarea rows="10" cols="30" name="answer">
		
		</textarea>
		<br>
		<input type="submit" value="提交答案">
	</form>
	${msg}
</body>
</html>