<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/testHistory.css">
<script type="text/javascript">
//返回一步
function backOne(){
	window.history.back(-1);
}
</script>
</head>
<body>
<c:import  url="head.jsp"/>
	
	<div class="cont">
		<a onclick="backOne();"><span class="glyphicon glyphicon-hand-left back"></span></a>
		<table class="table table-striped table-hover ">			
			<thead>
			    <tr>
			      <th>提交序号</th>
			      <th>用户名</th>
			      <th>试题名称</th>
			      <th>提交时间</th>
			      <th>评估结果</th>
			      <th>得分</th>
			      <th>评测详情</th>
			    </tr>
			 </thead>
			 <tbody>
			 	<c:forEach items="${responses}" var="r">
					<tr>
						<td>${r.id }</td>
						<td>${r.userName }</td>
						<td><a href="${rootPath}front/toQuestion?qtId=${r.qtId}&raceId=${r.raceId}">${r.qtName }</a></td>
						<td>${r.writeDate } </td>
						<td>${r.status }</td>
						<td>${r.score }</td>
						<td><a href="${rootPath}front/toDetails?resId=${r.id}">评测详情</a></td>			
					</tr>
				</c:forEach>
			 </tbody>			
		</table>
	</div>
	<c:import  url="footer.jsp"/>
</body>
</html>