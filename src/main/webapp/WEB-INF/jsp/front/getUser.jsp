<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/getUser.css">
</head>
<body>
<c:import  url="head.jsp"/>
	<div class="cont">
		<div class="panel panel-default">
		    <div class="panel-heading panel-heading2 ">
		    个人信息
		    </div>
			<div class="tab-pane fade in active panel-body panel-body2"   >
		      	<form class="bs-example bs-example-form" role="form" action="${rootPath}front/update" method="post"  >
					<div class="input-group input-group-lg">
						<span class="input-group-addon">用&nbsp;&nbsp;户&nbsp;&nbsp;名</span>
						<input type="text" disabled="disabled" class="form-control" value="${user.username}"  name="username">
					</div><br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名 </span>
						<input type="text" class="form-control" value="${user.name}" name="name">
					</div><br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon">手&nbsp;&nbsp;机&nbsp;&nbsp;号</span>
						<input type="text" class="form-control" value="${user.phone}" name="phone">
					</div><br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱 </span>
						<input type="text" class="form-control" value="${user.email}" name="email">
					</div><br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 </span>
						<input type="password" class="form-control" value="${user.password}"  name="password">
					</div><br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon">注册日期</span>
						<input type="text" disabled="disabled" class="form-control" value="${user.createDate}" name="createDate">							
					</div><br>
					<div class="submit">						
						<input class="btn btn-success btn-lg" type="submit" value="修 改">
					</div>
					<h4>${msg }</h4>
				</form>
		    </div>
		</div>			  
	</div>
<c:import  url="footer.jsp"/>
	
<script src="${rootPath}js/jquery.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</body>
</html>