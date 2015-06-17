// Loading required libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Model2Servlet extends HttpServlet{
    
   // public String loginUrl = "SessionLoginServlet";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
      
      
      String logado = (String)session.getAttribute("logado");
      if(logado != null && logado.equals("true"))
      {
          RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
          rd.forward(request, response);
      }
      else{
          
          String userName = request.getParameter("userName");
          String password = request.getParameter("password");
          
          if (userName==null){
          RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
          rd.forward(request, response);                    
      }
      else {
          if (password!=null && userName.equals("daniel") 
                  && password.equals("daniel")){
              // login sucessful
              session.setAttribute("logado", "true");
              RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
              rd.forward(request, response);
          }
          else{
              // login failed
              request.setAttribute("error","yes");
              RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
              rd.forward(request, response);
          }
      }
  }
        
        
        
    }
    
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException{
            
           processRequest(request, response);
      }
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException{
  {
      processRequest(request, response);
  }
      
  }
}
  






