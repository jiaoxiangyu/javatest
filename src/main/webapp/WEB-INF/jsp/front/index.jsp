<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统 </title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/index.css">
</head>
<body>
<c:import  url="head.jsp"/>
	<div class="cont">
		<pre>
			<h3>欢迎使用Java算法测试系统</h3>
    本系统将帮助参赛的同学熟悉比赛试题的形式和解题方式。通过使用本系统，同学可以学习到一些重要的编程方法，提高自己的编程水平，在大赛中取得更好的名次，提升自己的竞争力。

本系统的特点：

1. 入门引导：设置入门引导试题，帮助同学了解比赛的命题形式和解题方法。

2. 试题分组：具有相同难度和特点的试题形成一组，同组的试题具有相关性，帮助同学学习与提高程序设计、算法、数据结构的知识。

3. 不断更新的试题：系统不定期更新试题，保证同学的训练量。

4. 测试管理：可以将练习系统的题目进行组卷，进行分数统计，方便院校在大赛报名中校内选拔出优秀选手。

5. 查看评测数据：VIP用户允许查看评测数据，帮助你更有效的练习和提高。

6. 比赛环境：使用和软件大赛相同的测试环境进行测试，有效的模拟大赛的评测。

7. 即时评测：提交答案后马上进行评测并给出评测结果，方便同学了解自己程序的不足，对自己的程序进行改进。
		</pre>
	</div>
<c:import  url="footer.jsp"/>
	
<script src="${rootPath}js/jquery.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</body>
</html>