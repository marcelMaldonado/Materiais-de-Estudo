// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SessionLoginServlet extends HttpServlet{

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      sendLoginForm(response, false);
  }

  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException{
      String userName = request.getParameter("userName");
      String password = request.getParameter("password");
      if (login(userName,password)){
          // envia cookie para o browser
          HttpSession session = request.getSession(true);
          session.setAttribute("loggedIn",new String("true"));
          response.sendRedirect("s2");
      }
      else{
          sendLoginForm(response, true);
      }
  }

  private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage)
          throws ServletException, IOException{
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          out.println("<HTML>");
          out.println("<HEAD>");
          out.println("<TITLE>Login</TITLE>");
          out.println("</HEAD>");
          out.println("<BODY>");
          out.println("<CENTER>");
          if(withErrorMessage){
              out.println("Login failed. Please try again.<BR>");
              out.println("Cookies might be off.");
              // link para ajuda para ablitar cookies
          }
          out.println("<BR>");
          out.println("<BR><H2>Login Page</H2>");
          out.println("<BR>");
          out.println("<BR>Please enter your user name and passaword.");
          out.println("<BR>");
          out.println("<BR><FORM METHOD=POST>");
          out.println("<TABLE>");
          out.println("<TR>");
          out.println("<TD>User Name:</TD>");
          out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
          out.println("</TR>");
          out.println("<TR>");
          out.println("<TD>Password:</TD>");
          out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
          out.println("</TR>");
          out.println("<TR>");
          out.println("<TD ALIGN=RIGHT COLSPAN=2>");
          out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
          out.println("</TR>");
          out.println("</TABLE>");
          out.println("</FORM>");
          out.println("</CENTER>");
          out.println("</BODY>");
          out.println("</HTML>");
  }

  public static boolean login(String userName, String password)throws ServletException{
      try {
      // JDBC driver name and database URL
      String JDBC_DRIVER="com.mysql.jdbc.Driver";
      String DB_URL="jdbc:mysql://localhost/pgmc";
      //  Database credentials
      String USER = "root";
      String PASS = "";
          Class.forName(JDBC_DRIVER);
          Connection con =
                  DriverManager.getConnection(DB_URL,USER,PASS);
          Statement s = con.createStatement();
          String sql = "SELECT username, password FROM usuario"+
                  " WHERE username='"+userName+"'"+
                  " AND password='"+password+"'";
          ResultSet rs = s.executeQuery(sql);
          if(rs.next()){
              rs.close();
              s.close();
              con.close();
              return true;
          }
              rs.close();
              s.close();
              con.close();
      }
      catch(ClassNotFoundException e){
          throw new ServletException(e);
      }
      catch(SQLException e){
        throw new ServletException(e);
      }
      catch(Exception e){
        throw new ServletException(e);
      }
      return false;
  }
}











