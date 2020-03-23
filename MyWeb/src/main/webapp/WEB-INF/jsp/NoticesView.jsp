<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<style>
   <%@include file='styles/menu.css' %>
   <%@include file='styles/NoticesList.css' %>
</style>
 <head>
    <meta charset="UTF-8">
    <title>Notices List</title>
 </head>
 <body>
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
     
  <br>   
<a href="createNotices" class="c">Добавить объявление</a>
    <p style="color: red;">${errorString}</p>
    
   <table align="center">
   <th>Дата</th>
   <th width="800">Сообщение</th>
   <th width="150">Пользователь</th>
   <th width="150">Управление</th>
   
       <c:forEach items="${noticesList}" var="notices" >
          
          <tr>
          <td><p>${notices.notices_date}</p> </td>
          <td><p>${notices.content}</p> </td>
          <td><p>${notices.user_name}</p></td>
          <td>
          <ul class="menu">
          <c:choose>
            <c:when test="${user == notices.user_name or user == 'Admin' }">
    <li><p class="blink">Жми</p>
            
        <ul class="submenu">
            <li><a href="editNotices?notices_id=${notices.notices_id}">Изменить</a></li>
            <li><a href="deletenotices?notices_id=${notices.notices_id}" >Удалить</a></li> 
        </ul>
        </li>
         </c:when>
    </c:choose>
        </ul>
          </td>
          </tr>    
       </c:forEach>
  </table>
  <br>
  <br>
       <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>