
// Um servlet simples para implementar um contador de paginas

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionLifeCycleEventDemo implements ServletContextListener, HttpSessionListener
{
     ServletContext servletContext;
     int counter=0;
     public void contextInitialized(ServletContextEvent sce) {
             servletContext = sce.getServletContext();
             // inicialize o atributo de contexto COUNTER aqui
             servletContext.setAttribute("COUNTER",Integer.toString(counter));
             System.out.println("Context created.");
     }
     public void contextDestroyed(ServletContextEvent sce){
         System.out.println("Context destroyed.");
     }
     public void sessionCreated(HttpSessionEvent hse){
         System.out.println("Session created.");
          // atualise a variavel de contexto COUNTER aqui
         incrementUserCounter();
     }
     public void sessionDestroyed(HttpSessionEvent hse){
         System.out.println("Session destroyed.");
          // atualise a variavel de contexto COUNTER aqui
         decrementUserCounter();
     }
     synchronized void incrementUserCounter(){
         counter = Integer.parseInt((String)servletContext.getAttribute("COUNTER"));
         counter++;
         servletContext.setAttribute("COUNTER",Integer.toString(counter));
         System.out.println("User Count: "+counter);
     }
       synchronized void decrementUserCounter(){
         counter = Integer.parseInt((String)servletContext.getAttribute("COUNTER"));
         counter--;
         servletContext.setAttribute("COUNTER",Integer.toString(counter));
         System.out.println("User Count: "+counter);
     }
}
