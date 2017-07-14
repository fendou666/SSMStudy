<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>登陆成功，用户信息是:</p>
	<div>
		<table>
			<tr>
				<td>用户名</td>
				<td>密码</td>
			</tr>
			<c:forEach var="tmp" items="${requestScope.userList}">
				<tr>
					<td>${tmp.name}</td>
					<td>${tmp.pwd}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>