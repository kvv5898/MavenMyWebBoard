<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit User Account</title>
   </head>
   <body>
 
      <h3>Редактирование учетной записи пользователя</h3>
 
      <p style="color: red;">${errorString}</p>
 
         <form method="POST" action="${pageContext.request.contextPath}/edituser">
            <table border="1">
               <tr>
                   <td>USER_ID</td>
                   <td style="color:red;"><input type="hidden" name="user_id" value="${User_account.user_id}" />${User_account.user_id}</td>
               </tr>
               <tr>
                   <td>USER_NAME</td>
                   <td><input type="text" name="user_name" value="${User_account.user_name}" /></td>
               </tr>
               <tr>
               
                  <td>email</td>
                  <td><input type="text" name="email" value="${User_account.email}" /></td>
               </tr>
               <tr>
                  <td>PASSWORD</td>
                  <td><input type="text" name="password" value="${User_account.password}" /></td>
               </tr>
               <tr>
               <td>Date</td>
                  <td><input type="text" name="us_Date" value="${User_account.us_Date}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Применить" />
                      <a href="${pageContext.request.contextPath}/user">Назад</a>
                  </td>
               </tr>
            </table>
         </form>
   </body>
</html>