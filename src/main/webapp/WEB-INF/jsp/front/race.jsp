<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/race.css">
</head>
<body>
<c:import url="head.jsp" />
	<div class="cont">
		<table class="table table-striped table-hover " >	
			 <caption>算法竞赛</caption>	
			 <thead>
			    <tr>
			      <th>竞赛编号</th>
			      <th>竞赛名称</th>
			      <th>开始时间</th>
			      <th>结束时间</th>
			      <th>竞赛状态</th>
			      <th>得分</th>			      
			      <th>竞赛详情</th>
			    </tr>
			  </thead>
			  <tbody>
					<c:forEach items="${races}" var="r">
						<tr>
							<td>${r.id}</td>
							<td>${r.name }</td>
							<td>${r.startDate }</td>
							<td>${r.endDate }</td>
							<td>${r.join }</td>
							<td>${r.score }</td>
							<td>
							<c:if test="${r.join=='未开始'}"><em style="color:red;">不可进入</em></c:if>	
							<c:if test="${r.join=='竞赛中'}">
								<a href="${rootPath}front/raceDetails?raceId=${r.id}">进入竞赛</a>
							</c:if>								
							<c:if test="${r.join!='未开始' && r.join!='竞赛中'}">
								<a href="${rootPath}front/raceDetails?raceId=${r.id}">竞赛详情</a>
							</c:if>	
											
							</td>
						</tr>
					</c:forEach>
			  </tbody>
		</table>
		${msg }
	</div>
<c:import url="footer.jsp" />
</body>
</html>