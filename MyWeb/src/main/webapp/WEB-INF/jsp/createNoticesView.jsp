<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Notices</title>
   </head>
   <body>
    
       
      <h3>Create Notices</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createNotices">
      <input type="hidden" name="userName" value="${name}"/>
         <table border="1">
            <tr>
               <td>Content</td>
               <td><input type="text" name="content" value="${notices.content}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="notices">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
       
   </body>
</html>