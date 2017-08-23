<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统</title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/questionType.css">
</head>
<body>
	<c:import  url="head.jsp"/>
	<div class="cont">
		<table class="table table-striped table-hover " >	
			 <caption>试题集</caption>	
			 <thead>
			    <tr>
			      <th>试题集名称</th>
			      <th>试题总数</th>
			      <th>已解决数量</th>
			      <th>更新时间</th>
			      <th>进入试题集</th>
			    </tr>
			  </thead>
			  <tbody>
					<c:forEach items="${types}" var="t">
						<tr>
							<td><a href="${rootPath}front/toType?typeId=${t.id}">${t.name}</a></td>
							<td>${t.qtNum }</td>
							<td>${t.solvedNum }</td>
							<td>${t.updateDate }</td>
							<td><a href="${rootPath}front/toType?typeId=${t.id}">进入试题集</a></td>
						</tr>
					</c:forEach>
			  </tbody>
		</table>
		${msg }
	</div>
	<c:import  url="footer.jsp"/>
	
<script src="${rootPath}js/jquery.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</body>
</html>