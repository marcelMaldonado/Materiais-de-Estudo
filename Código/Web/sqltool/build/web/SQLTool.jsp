<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EM"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<jsp:useBean id="SQLToolBean" class="com.ufjf.si.labprog4.SQLToolBean">
<jsp:setProperty name="SQLToolBean" property = "userName"/>
<jsp:setProperty name="SQLToolBean" property = "password"/>
<jsp:setProperty name="SQLToolBean" property = "sql"/>
</jsp:useBean>
                 
<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>SQL Tool</title>
   </head>
   <body>
   <BR><H2>SQL Tool</H2>
   <BR>Please, type your SQL statment in the following box.
   <BR>
   <BR><FORM METHOD=POST>
   <TEXTAREA NAME=sql COLS=80 ROWS=8>
   input here
   </TEXTAREA>
   <BR>
   <INPUT TYPE = "hidden" name = "userName" value = "${param.userName}">    
   <INPUT TYPE = "hidden" name = "password" value = "${param.password}">
   <INPUT TYPE=SUBMIT>
   </FORM>
   <BR>
   <HR>
   <BR> 
   <%= SQLToolBean.getResult() %>
   </BODY>
   </HTML> 	
   </BODY>
</html>

