<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import  url="head.jsp"/>
<a href="${rootPath}front/toQuestion?qtId=${response.qtId}"> << 返回</a><br>

提交序号	${response.id }<br>
作者	${response.userName }<br>
提交时间	${response.writeDate }<br>
评测结果	${response.status }<br>
得分	${response.score }<br>
<%-- CPU使用	${response.time }<br>
内存使用	${response.memory }<br> --%>
试题名称	${response.qtName }<br>
语言	JAVA<br>
源代码 <p>${response.answer }</p>
<br>
<c:choose>
	<c:when test="${err==null }">
		
	<table>
		<tr>
			<td>评测点序号</td>
			<td>评测结果</td>
			<td>得分</td>
			<td>CPU使用</td>
			<td>内存使用</td>
			<td>下载评测数据</td>			
		</tr>
		<c:forEach items="${testDetailss}" var="t">
			<tr>
				<td>${t.orderId }</td>
				<td>${t.result }</td>
				<td>${t.score }</td>
				<td>${t.time} ms</td>
				<td>${t.memory} M</td>
				<td>
					<a href="${rootPath}front/download?temp=in&qtId=${t.qtId}&orderId=${t.orderId}">输入</a> 
					<a href="${rootPath}front/download?temp=out&qtId=${t.qtId}&orderId=${t.orderId}">输出</a>
				</td>			
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
		错误信息：${err }		
	</c:otherwise>
</c:choose>
	
</body>
</html>