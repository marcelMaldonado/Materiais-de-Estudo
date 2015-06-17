// Fig. 26.7: WelcomeServlet.java
// Um servlet simples para processar solicita��es get.
import javax.servlet.ServletException;        
import javax.servlet.http.HttpServlet;        
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet
{
   // processa solicita��es "get" dos clientes            
   protected void doGet( HttpServletRequest request,
      HttpServletResponse response )                 
         throws ServletException, IOException        
   {
      String firstName = (String)request.getAttribute("firstName"); 
      response.setContentType( "text/html" );
      PrintWriter out = response.getWriter();
      
      // envia p�gina de XHTML para o cliente

      // inicia o documento XHTML                    
      out.println( "<?xml version = \"1.0\"?>" );

      out.printf( "%s%s%s", "<!DOCTYPE html PUBLIC", 
         " \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
         " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" );

      out.println( "<html xmlns = \"http://www.w3.org/1999/xhtml\">" );
      
      // se��o da cabe�a do documento
      out.println( "<head>" );
      out.println( "<title>A Simple Servlet Example</title>" );
      out.println( "</head>" );
      
      // se��o do corpo do documento
      out.println( "<body>" );
      out.println( "<h1>Olá"+" "+firstName+"</h1>" );
      out.println( "</body>" );
      
      // fim do documento XHTML
      out.println( "</html>" );
      out.close();  // fecha o fluxo para completar a p�gina
   } // fim do m�todo doGet
} // fim da classe WelcomeServlet


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/