
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Model2Servlet extends HttpServlet{
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
      
      
      String logado = (String)session.getAttribute("logado");
      if(logado != null && logado.equals("true"))
      {
          request.setAttribute("teste","a");
          RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
          rd.forward(request, response);
      }
      else{
          request.setAttribute("teste",null);
          String userName = request.getParameter("userName");
          String password = request.getParameter("password");
          
          if (userName==null){
          RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
          rd.forward(request, response);                    
      }
      else {
          if (password!=null && userName.equals("leojayme") 
                  && password.equals("manso")){
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
  






