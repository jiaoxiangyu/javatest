<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/type.css">
</head>
<body>
	<c:import  url="head.jsp"/>
	<div class="cont">
		<a class="back" href="${rootPath}front/questionType"><span class="glyphicon glyphicon-hand-left back"></span></a>
		<table class="table table-striped table-hover ">
			<thead>
			    <tr>
			      <th>试题编号</th>
			      <th>试题名称</th>
			      <th>关键字</th>
			      <th>更新时间</th>
			      <th>试题状态</th>
			      <th>进入试题</th>
			      <th>提交记录</th>
			    </tr>
			 </thead>
			 <tbody>
			 	<c:forEach items="${questions}" var="q">
			 		<tr>
						<td>${q.id }</td>
						<td><a href="${rootPath}front/toQuestion?qtId=${q.id}">${q.name }</a></td>
						<td>${q.keyword }</td>
						<td>${q.createDate }</td>
						<td>${q.status }</td>
						<td><a href="${rootPath}front/toQuestion?qtId=${q.id}">进入试题</a></td>
						<td><a href="${rootPath}front/submitHistory?qtId=${q.id}">提交记录</a></td>
					</tr> 
				</c:forEach>
			 </tbody>			
		</table>
		${msg }
	</div>
	<c:import  url="footer.jsp"/>
</body>
</html>