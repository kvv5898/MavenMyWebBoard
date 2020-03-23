<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Notices</title>
   </head>
   <body>
        <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
 
      <h3>Редактирование объявления</h3>
 
      <p style="color: red;">${errorString}</p>
 
         <c:if test="${not empty edit_Notices}">
         <form method="POST" action="${pageContext.request.contextPath}/editNotices">
            <input type="hidden" name="userName" value="${loginedUser.userName}"/>
            <table border="1">
            <tr>
                   <td>Notices_ID</td>
                   <td style="color:red;"><input type="hidden" name="notices_id" value="${edit_Notices.notices_id}" />${edit_Notices.notices_id}</td>
               </tr>
             <tr>
                   <td>Date</td>
                   <td style="color:red;"><input type="hidden" name="notices_date" value="${edit_Notices.notices_date}" />${edit_Notices.notices_date}</td>
               </tr>
               <tr>
                   <td>USER_NAME</td>
                   <td style="color:red;"><input type="hidden" name="user_name" value="${edit_Notices.user_name}" />${edit_Notices.user_name}</td>
               </tr>
               <tr>
                  <td>CONTENT</td>
                  <td><input type="text" name="content" value="${edit_Notices.content}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Применить" />
                      <a href="${pageContext.request.contextPath}/notices">Назад</a>
                  </td>
               </tr>
            </table>
         </form>
            </c:if>
                  <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>