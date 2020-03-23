<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User View</title>

</head>
<body>
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
	<p>Действующие пользователи</p>
	<table border="1">
		<c:forEach var="userinfo" items="${userinfo}">
			<tr>
				<td>${userinfo.us_Date}</td>
				<td>${userinfo.user_name}</td>
				<td>${userinfo.email}</td>
				<td>${userinfo.password}</td>
				<td><a href="userdel?user_id=${userinfo.user_id}&user_name=${userinfo.user_name}">Удалить</a></td>
				<td><a href="edituser?user_id=${userinfo.user_id}">Изменить</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="adduser">Добавить пользователя</a>
</body>
</html>