<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/raceDetails.css">
</head>
<body>
<c:import url="head.jsp" />
	<div class="cont">
		<div class="title">${raceDetailss[0].raceName}</div>	
		<a  href="${rootPath}front/race"><span class="glyphicon glyphicon-hand-left back"></span></a>
		<table class="table table-striped table-hover " >				 
			 <thead>
			    <tr>
			      <th>编号</th>
			      <th>试题名称</th>
			      <th>试题状态</th>
			      <th>得分</th>
			      <th>提交时间</th>
			      <th>进入试题</th>			      
			      <th>提交记录</th>
			    </tr>
			  </thead>
			  <tbody>
					<c:forEach items="${raceDetailss}" var="r" varStatus="i">
						<tr>
							<td>${i.index+1}</td>
							<td><a href="${rootPath}front/toQuestion?qtId=${r.qtId}&raceId=${r.raceId}">${r.qtName }</a></td>
							<td>${r.status }</td>
							<td>${r.score }</td>
							<td>${r.writeTime }</td>
							<td><a href="${rootPath}front/toQuestion?qtId=${r.qtId}&raceId=${r.raceId}">进入试题</a></td>
							<td><a href="${rootPath}front/submitHistory?qtId=${r.qtId}&raceId=${r.raceId}">提交记录</a></td>
						</tr>
					</c:forEach>
			  </tbody>
		</table>
		${msg }
	</div>
<c:import url="footer.jsp" />
</body>
</html>