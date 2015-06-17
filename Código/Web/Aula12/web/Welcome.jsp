
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
      if (request.getAttribute("teste")==null){
          response.sendRedirect("Model2Servlet");
      }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        
        <h1>Login efetuado com sucesso.</h1>
       <%String logado = getInitParameter("logado");%>         
    </body>
</html>
