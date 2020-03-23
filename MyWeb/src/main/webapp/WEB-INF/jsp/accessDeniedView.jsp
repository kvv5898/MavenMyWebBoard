<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Access Denied</title>
   </head>
   <body>
      <br/><br/>
       
      <h3 style="color:red;">Доступ запрещен !</h3>
      <a href="${pageContext.request.contextPath}/login">Авторизоваться</a>       
   </body>
</html>