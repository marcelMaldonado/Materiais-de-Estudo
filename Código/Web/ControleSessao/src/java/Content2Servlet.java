// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Content2Servlet extends HttpServlet{
  public String loginUrl = "s1";
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      doGet(request,response);
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException{

      HttpSession session = request.getSession(false);
      if (session==null)
          response.sendRedirect(loginUrl);
      else{
          String loggedIn = (String)
                  session.getAttribute("loggedIn");
          if(!loggedIn.equals("true"))
              response.sendRedirect(loginUrl);
      }
      response.setContentType("text/html");
      // Usuario autorizado
      PrintWriter out = response.getWriter();
      out.println("<HTML>");
      out.println("<HEAD>");
      out.println("<TITLE>Welcome</TITLE>");
      out.println("</HEAD>");
      out.println("<BODY>");
      out.println("Welcome");
      out.println("</BODY>");
      out.println("</HTML>");
  }
}






