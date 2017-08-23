<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Java算法练习系统--登录</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">  
<link rel="stylesheet" href="${rootPath}css/index.css">
</head>
<body>
<div class="container border">
	

		<div class="panel panel-default">
		    <div class="panel-heading title2">
		    	<ul id="myTab" class="nav nav-tabs" >
					<li class="active" >
						<a href="#login" data-toggle="tab">登&nbsp;&nbsp;录</a>
					</li>
					<li><a href="#register" data-toggle="tab">注&nbsp;&nbsp;册</a></li>			
				</ul>
		        
		    </div>
		    <div id="myTabContent" class="tab-content">
			 	<!--   登录 -->
			    <div class="tab-pane fade in active panel-body body2"  id="login" >
			      	<form class="bs-example bs-example-form" role="form" action="${rootPath}index/login" method="post"  >
						<div class="input-group input-group-lg">
							<span class="input-group-addon">用户名</span>
							<input type="text" class="form-control" placeholder="用户名或手机号" value="${username}" name="username">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码 </span>
							<input type="password" class="form-control" placeholder="请输入密码" value="${password}" name="password">
						</div><br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">验证码 </span>
							<input type="text" class="form-control" name="code">
							<span class="input-group-addon code">
							<img alt="换一张" src="${rootPath}/index/code" id="validateCodeImg" onclick="changeImg()">
							</span>
						</div><br>
						<div class="remember">
							<span  class="radio remember2"><input type="radio" name="remember">记住密码</span>
							
						  	<span class="forget"><a href="${rootPath}index/forget" target="_blank">忘记密码？</a></span>
						</div>
						<div class="login">
							<input class="btn btn-primary" type="reset" value="重 置">
							<input class="btn btn-success" type="submit" value="登 录">
						</div>
					</form>					
			    </div>
			   <!--  注册 -->
			    <div class="tab-pane fade panel-body body3"  id="register" >
			      	<form class="bs-example bs-example-form" role="form" action="${rootPath}index/register" method="post"  >
						<div class="input-group input-group-sm">
							<span class="input-group-addon">用&nbsp;&nbsp;户&nbsp;&nbsp;名 </span>
							<input type="text" class="form-control" placeholder="请输入用户名" name="username">
						</div><br>
						<div class="input-group input-group-sm">
							<span class="input-group-addon">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
							<input type="text" class="form-control" placeholder="请输入姓名" name="name">
						</div><br>
						<div class="input-group input-group-sm">
							<span class="input-group-addon">手&nbsp;&nbsp;机&nbsp;&nbsp;号</span>
							<input type="text" class="form-control" placeholder="请输入手机号" name="phone">
						</div><br>
						<div class="input-group input-group-sm">
							<span class="input-group-addon">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</span>
							<input type="text" class="form-control" placeholder="请输入邮箱" name="email">
						</div><br>
						<div class="input-group input-group-sm">
							<span class="input-group-addon">验&nbsp;&nbsp;证&nbsp;&nbsp;码 </span>
							<input type="text" class="form-control" placeholder="请输入验证码" name="code">
							<span class="input-group-addon code2">
							<img alt="换一张" src="${rootPath}/index/code" id="validateCodeImg2" onclick="changeImg2()">
							</span>
						</div><br>
						<div class="login2">
							<input class="btn btn-primary btn-sm" type="reset" value="重 置">
							<input class="btn btn-success btn-sm" type="submit" value="注册">
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