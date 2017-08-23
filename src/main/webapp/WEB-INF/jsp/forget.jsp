<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>忘记密码</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">  
<link rel="stylesheet" href="${rootPath}css/forget.css">
</head>
<body>
<div class="container border">
	

		<div class="panel panel-default">
		    <div class="panel-heading title2">
		    	<ul id="myTab" class="nav nav-tabs" >
					<li class="active" >
						<a href="#login" data-toggle="tab">邮箱找回</a>
					</li>
					<li><a href="#register" data-toggle="tab">手机号找回</a></li>			
				</ul>
		        
		    </div>
		    <div id="myTabContent" class="tab-content">
			 	<!--   邮箱找回 -->
			    <div class="tab-pane fade in active panel-body body2"  id="login" >
			      	<form class="bs-example bs-example-form" role="form" action="${rootPath}index/find?by=email" method="post"  >
						<div class="input-group input-group-lg">
							<span class="input-group-addon">用户名</span>
							<input type="text" class="form-control" placeholder="请输入用户名" value="${username}" name="username">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</span>
							<input type="text" class="form-control" placeholder="请输入邮箱" value="${password}" name="email">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">验证码 </span>
							<input type="text" class="form-control" name="code">
							<span class="input-group-addon code">
							<img alt="换一张" src="${rootPath}/index/code" id="validateCodeImg" onclick="changeImg()">
							</span>
						</div><br>						
						<div class="login">
							<input class="btn btn-primary" type="reset" value="重 置">
							<input class="btn btn-success" type="submit" value="找 回">
						</div>
					</form>					
			    </div>
			   <!--  手机号找回 -->
			    <div class="tab-pane fade panel-body body2"  id="register" >
			      <form class="bs-example bs-example-form" role="form" action="${rootPath}index/find?by=phone" method="post"  >
						<div class="input-group input-group-lg">
							<span class="input-group-addon">用户名</span>
							<input type="text" class="form-control" placeholder="请输入用户名" value="${username}" name="username">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">手机号</span>
							<input type="text" class="form-control" placeholder="请输入手机号" value="${password}" name="email">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">验证码 </span>
							<input type="text" class="form-control" name="code">
							<span class="input-group-addon code">
							<img alt="换一张" src="${rootPath}/index/code" id="validateCodeImg2" onclick="changeImg2()">
							</span>
						</div><br>						
						<div class="login">
							<input class="btn btn-primary" type="reset" value="重 置">
							<input class="btn btn-success" type="submit" value="找 回">
						</div>
					</form>		
			    </div>		
			    <h4 style="color:red; margin-top:-10px;">${msg}</h4>	   
		    </div>
		</div>

</div>

<script src="${rootPath}js/jquery.js"></script>
<script type="text/javascript">
    //刷新登录验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${rootPath}/index/code?"+Math.random();
    }  
    //刷新注册验证码
    function changeImg2(){
        document.getElementById("validateCodeImg2").src="${rootPath}/index/code?"+Math.random();
    }  
    </script>
<script src="${rootPath}js/bootstrap.js"></script>
</body>
</html>