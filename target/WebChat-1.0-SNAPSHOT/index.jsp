<%-- 
    Document   : index
    Created on : 6 mars 2015, 11:21:56
    Author     : Licence
--%>
<%@ page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= request.getParameter("name") %>!</h1>
     <%
      java.util.ArrayList al = new java.util.ArrayList ();
      al = (ArrayList) request.getAttribute("conversation");

        if (al.size() == 0 )
        out.println ("nothing...");
        else
        {
            for (int i=0; i<al.size(); i++)
            {
                out.println(al.get(i)+"<br />");
            }
        }

      %>
      

        <form id ="msg" method="POST">
                <textarea rows = "4" cols =" 50 " name ="comment">
Enter your message here ...
                </textarea>
                <input type ="submit">
            </form>
            
            
    </body>
</html>
