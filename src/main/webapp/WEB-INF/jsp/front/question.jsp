<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统</title>
<link rel="stylesheet" type="text/css"
	href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath}css/front/question.css">
<script type="text/javascript">
	String.prototype.trim2 = function() {
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
	function F(objid) {
		return document.getElementById(objid).value;
	}
	function G(objid) {
		return document.getElementById(objid);
	}
	
	//返回一步
	function backOne(){
		window.history.back(-1);
	}
</script>
</head>
<body onLoad="keyUp();">
	<c:import url="head.jsp" />
	<div class="cont">
		<a onclick="backOne();"><span class="glyphicon glyphicon-hand-left back"></span></a>

		<div class="title">
			<h3>${question.name}</h3>
			<p>
				<span>时间限制：1.0 s</span><span>内存限制：256 M</span>
			<p>
		</div>

		<div class="quest">
			<pre>${question.content}</pre>
		</div>

		<div class="answer">
			<h3>你的答案</h3><h4></h4>
			<p>
				<span>温馨提示：</span>编译语言为<em>Java</em>；公共类类名为<em>Main</em>；不能导入package！
			</p>
			<span>你的代码：</span>
			<form action="${rootPath}front/toSubmit?qtId=${question.typeId}"
				method="post">
				<div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="position: relative">
						<tr>
							<td width="60%">
								<div id="ol">
									<textarea  cols="2" rows="10" id="li" disabled="disabled"></textarea>
								</div> <textarea name="answer"  cols="100" rows="20" wrap="off" id="c2"
									onblur="check('2')" onKeyUp="keyUp()" onFocus="clearValue('2')"
									onscroll="G('li').scrollTop=this.scrollTop;"
									oncontextmenu="return false" class="grey"></textarea>
							</td>
						</tr>
					</table>
				</div>	
				<div class="but">
					<input  class="btn btn-success"  type="submit" value="提交答案">
				</div>								
			</form>
			${msg}
		</div>

	</div>
	<c:import url="footer.jsp" />
</body>

<script type="text/javascript">
	var msgA = [ "msg1", "msg2", "msg3", "msg4" ];
	var c = [ "c1", "c2", "c3", "c4" ];
	var slen = [ 50, 20000, 20000, 60 ];//允许最大字数 
	var num = "";//http://www.phpernote.com/javascript-function/752.html 
	var isfirst = [ 0, 0, 0, 0, 0, 0 ];
	function isEmpty(strVal) {
		if (strVal == "")
			return true;
		else
			return false;
	}
	function isBlank(testVal) {
		var regVal = /^\s*$/;
		return (regVal.test(testVal))
	}
	function chLen(strVal) {
		strValstrVal = strVal.trim2();
		var cArr = strVal.match(/[^\x00-\xff]/ig);
		return strVal.length + (cArr == null ? 0 : cArr.length);
	}
	function check(i) {
		var iValue = F("c" + i);
		var iObj = G("msg" + i);
		var n = (chLen(iValue) > slen[i - 1]);
		if ((isBlank(iValue) == true) || (isEmpty(iValue) == true) || n == true) {
			iObj.style.display = "block";
		} else {
			iObj.style.display = "none";
		}
	}
	function checkAll() {
		for (var i = 0; i < msgA.length; i++) {
			check(i + 1);
			if (G(msgA[i]).style.display == "none") {
				continue;
			} else {
				alert("填写错误,请查看提示信息！");
				return;
			}
		}
		G("form1").submit();
	}
	function clearValue(i) {
		G(c[i - 1]).style.color = "#000";
		keyUp();
		if (isfirst[i] == 0) {
			G(c[i - 1]).value = "";
		}
		isfirst[i] = 1;
	}
	function keyUp() {
		var obj = G("c2");
		var str = obj.value;
		strstr = str.replace(/\r/gi, "");
		strstr = str.split("\n");
		n = str.length;
		line(n);
	}
	function line(n) {
		var lineobj = G("li");
		for (var i = 1; i <= n; i++) {
			if (document.all) {
				num += i + "\r\n";
			} else {
				num += i + "\n";
			}
		}
		lineobj.value = num;
		num = "";
	}
	function autoScroll() {
		var nV = 0;
		if (!document.all) {
			nV = G("c2").scrollTop;
			G("li").scrollTop = nV;
			setTimeout("autoScroll()", 20);
		}
	}
	if (!document.all) {
		window.addEventListener("load", autoScroll, false);
	}
</script>
</html>