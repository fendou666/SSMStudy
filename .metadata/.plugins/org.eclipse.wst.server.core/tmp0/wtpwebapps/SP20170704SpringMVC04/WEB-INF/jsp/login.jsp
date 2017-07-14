<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.err != null}">
		<span>错误信息：</span>
		<c:out value="${requestScope.err}"></c:out>		
	</c:if>
	<!-- 第四中  -->
	<form action="getUser.action" method="post">
	<!-- 第五中 -->
	<!-- <form action="getUser.action?method=getUser" method="post"> -->
		<span>用户名：</span>
		<input type="text" id="name" name="name"> <br/>
		<span>密码：</span>
		<input type="password" id="pwd" name="pwd"> <br/>		
		<input type="submit" value="提交">
	</form>	
</body>
</html>