
// Um servlet simples para implementar um contador de paginas

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserCounterServlet extends HttpServlet
{
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        // pegue o contexto da aplicacao aqui
        HttpSession session = request.getSession(true);
        ServletContext servletContext = request.getServletContext();
        // faca a sessao nao durar mais do que 30 segundos aqui
        session.setMaxInactiveInterval(3);
        int userCounter = 0;
        userCounter = Integer.parseInt((String)servletContext.getAttribute("COUNTER"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>User Counter</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("There are "+userCounter+" visitors");
        out.println("</BODY>");
        out.println("</HTML>");
     }
}
