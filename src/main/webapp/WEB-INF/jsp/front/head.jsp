<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/head.css">
</head>
<body>
	<nav class="navbar navbar-default menu" role="navigation">
		<div class="container-fluid">	
			<div class="navbar-header">				
				<div class="navbar-brand logo">Java算法练习系统&nbsp;</div>
			</div>	
			<div>
		        <ul class="nav navbar-nav" id="menu">
		            <li><a href="${rootPath}front/index">首页</a></li>
		            <li><a href="${rootPath}front/questionType">试题集</a></li>
		            <li><a href="${rootPath}front/toTestHistory">提交记录</a></li>
		            <li><a href="${rootPath}front/race">算法竞赛</a></li>
		            <li><a href="https://c.runoob.com/compile/10" target="_blank">在线工具</a></li>
		        </ul>
		     </div>
		     
		     <ul class="nav navbar-nav navbar-right">
			      <li><a href="${rootPath}front/getUser"><span class="glyphicon glyphicon-user"></span> ${user.name}</a></li>
			      <li><a href="${rootPath}index/logout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
		    </ul>
	    </div>
	</nav>
<script src="${rootPath}js/jquery.js"></script>	
<script type="text/javascript">
var urlstr = location.href;  
//alert(urlstr);  
var urlstatus=false;  
$("#menu a").each(function () {  
	  if ((urlstr + '/').indexOf($(this).attr('href')) > -1&&$(this).attr('href')!='') {  
	    $(this).addClass('cur'); urlstatus = true;  
	  } else {  
	    $(this).removeClass('cur');  
	  }  
}); 

if (!urlstatus) {
	$("#menu a").eq(0).addClass('cur');
} 
</script>	

<script src="${rootPath}js/bootstrap.js"></script>
</body>
</html>