<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <html>
  <head>
   </html>
<body>
<div style="background: lightblue; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Интернет доска объявлений</h1>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
  <c:choose>
      <c:when test="${logUser.user_name== null }"><a href="${pageContext.request.contextPath}/login">Войти</a></c:when>
      <c:otherwise>Привет <b>${logUser.user_name}</b>
   <br/>
      <a href="${pageContext.request.contextPath}/exit">Выход</a></c:otherwise>
  </c:choose>
 
  </div>
 
</div>
</body>
</html>