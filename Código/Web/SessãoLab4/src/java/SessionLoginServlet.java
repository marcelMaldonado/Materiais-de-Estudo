/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel
 */
public class SessionLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessionLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SessionLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       sendLoginForm(response, false);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String userName = request.getParameter("userName");
      String password = request.getParameter("password");
      if (login(userName,password)){
          // envia cookie para o browser
          HttpSession session = request.getSession(true);
          session.setAttribute("loggedIn",new String("true"));
          response.sendRedirect("Content2Servlet");
      }
      else{
          sendLoginForm(response, true);
      }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
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
      String PASS = "root";
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
