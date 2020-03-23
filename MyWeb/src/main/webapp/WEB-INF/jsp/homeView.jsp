<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
      <h3>Добро пожаловать </h3>
      
      Этот сайт только для зарегистрированных пользователей<br><br>
      <b>Возможности сайта:</b>
      <ul>
         <li>Просмотр всех объявлений</li>
         <li>Добавление объявлений</li>
         <li>Редактирование объявлений</li>
      </ul>
      <br><br>
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>