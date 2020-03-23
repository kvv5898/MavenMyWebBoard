<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ page import="java.util.Date,java.text.*"%>
 
<%
  Date now = new Date();
 
  DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  
  
%>
  
   <html> <head>
<script type="text/javascript">
function startTime()
{
var tm=new Date();
var yyyy=tm.getFullYear();
var mm=tm.getMonth()+1;
var dd=tm.getDate();
var h=tm.getHours();
var m=tm.getMinutes();
var s=tm.getSeconds();
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=  dd+"/"+mm+"/"+yyyy+"-"+h+":"+m+":"+s;
t=setTimeout('startTime()',500);
}
function checkTime(i)
{
if (i<10)
{
i="0" + i;
}
return i;
}
</script> </head> <body onload="startTime()"> <p style="float: right" id="txt"> </p> </body> </html>
  
 <marquee behavior="scroll" direction="right" bgcolor="lightblue">
     @KVVproduction
  </marquee>
   