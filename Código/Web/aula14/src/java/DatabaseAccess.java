// Loading required libraries

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseAccess extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("firstname").toString();

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType
                + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n");
        try {
         
            DAO dao = new DAO();

            Vector<Aluno> rs = dao.buscar(name);
            Iterator it = rs.iterator();
            // Extract data from result set
            while (it.hasNext()) {
                Aluno aux = (Aluno) it;
                //Retrieve by column name
                String bolsa = aux.getNome();
                String nivel = aux.getMatricula();
                String nome = aux.getNivel();
                String matricula = aux.getBolsa();
                String inicio = aux.getEntrada().toString();
                //Display values
                out.print(" Nome :  " + nome + "<br>");
                out.print(" CPF :  " + matricula + "<br>");
                out.print(" Bolsa :  " + bolsa + "<br>");
                out.print(" Inicio :  " + inicio + "<br>");
                out.println("Nivel :  " + nivel + "<br>");
            }
            out.println("</body></html>");
         
        } catch (SQLException e) {
         
        } catch (Exception e) {
         
        } //end try
    }
}
