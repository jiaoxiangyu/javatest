<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java算法练习系统</title>
<link rel="stylesheet" type="text/css" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${rootPath}css/front/testDetails.css">
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
<c:import  url="head.jsp"/>
<div class="cont">
	<a onclick="backOne();"><span class="glyphicon glyphicon-hand-left back"></span></a>
	<div class="uli">
		<ul >	
		<li><span>提交序号：</span>${response.id }</li>
		<li><span>作者：</span>${response.userName }</li>
		<li><span>提交时间：</span>${response.writeDate }</li>
		<li><span>评测结果：</span>${response.status }</li>
		<li><span>得分：</span>${response.score }</li>		
		<li><span>试题名称：</span><a href="${rootPath}front/toQuestion?qtId=${response.qtId}&raceId=${response.raceId}">${response.qtName }</a></li>
		<c:if test="${response.raceName!=null }">
			<li><span>竞赛名称：</span><a href="${rootPath}front/raceDetails?raceId=${response.raceId}">${response.raceName}</a></li>	
		</c:if>
		<li><span>语言：</span>JAVA</li>
	</ul>	
	</div>
	
	<b>源代码 ：</b>
	<div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="position: relative">
			<tr>
				<td width="60%">
					<div id="ol">
						<textarea  cols="2" rows="10" id="li" disabled="disabled"></textarea>
					</div> 
					<textarea   cols="100" rows="20" wrap="off" id="c2" disabled="disabled"
						onblur="check('2')" onKeyUp="keyUp()" onFocus="clearValue('2')"
						onscroll="G('li').scrollTop=this.scrollTop;"
						oncontextmenu="return false" class="grey">${response.answer }</textarea>
				</td>
			</tr>
		</table>
	</div>	
	
	<div class="tests">
		<c:choose>
			<c:when test="${response.err==null }">
				<table class="table table-striped table-hover ">
					<caption>测试详情</caption>
					<thead>
						<tr>
							<th>评测点序号</th>
							<th>评测结果</th>
							<th>得分</th>
							<th>CPU使用</th>
							<th>内存使用</th>
							<th>下载评测数据</th>	
						</tr>		
					</thead>
					<tbody>
						<c:forEach items="${testDetailss}" var="t">
							<tr>
								<td>${t.orderId }</td>
								<td>${t.result }</td>
								<td>${t.score }</td>
								<td>${t.time} ms</td>
								<td>${t.memory} M</td>
								<td>
									&nbsp;&nbsp;<a href="${rootPath}front/download?temp=in&qtId=${t.qtId}&orderId=${t.orderId}">输入</a>&nbsp;&nbsp; 
									<a href="${rootPath}front/download?temp=out&qtId=${t.qtId}&orderId=${t.orderId}">输出</a>
								</td>			
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<b>错误信息：</b>
				<pre>${response.err}</pre>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<c:import  url="footer.jsp"/>
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