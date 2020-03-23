<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
    <html>
    <style>
   <%@include file='styles/style.css' %>
</style>
 <head>
 
    </head> 
    
 <p align="right">   <c:choose>
    <c:when test="${logUser.user_name == 'Admin'}">
        <a href="${pageContext.request.contextPath}/user">Админка</a>
    </c:when>
</c:choose>
  </p>    
<div class="menu">

   <a href="${pageContext.request.contextPath}/home">Информация</a>
  
   <a href="${pageContext.request.contextPath}/adduser">Регистрация</a>
   
   <a href="${pageContext.request.contextPath}/notices">Объявления</a>
  
   <a href="${pageContext.request.contextPath}/login">Авторизация</a>
   
    
</div>  <br><br>

</html>