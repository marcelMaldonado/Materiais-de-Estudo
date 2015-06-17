import java.io.*; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import java.util.Enumeration; 

public class UpperCaseFilter implements Filter {
  private FilterConfig filterConfig = null; 
  public void destroy() {
    System.out.println("Filter destroyed"); 
    this.filterConfig = null; 
  } 

  public void doFilter(ServletRequest request, ServletResponse response, 
    FilterChain chain) 
    throws IOException, ServletException {
    System.out.println("Filter"); 
    Enumeration en = request.getParameterNames(); 
    while (en.hasMoreElements()) {
      String attributeName = (String) en.nextElement(); 
      String attributeValue = (String) request.getParameter(attributeName); 
      request.setAttribute(attributeName, attributeValue.toUpperCase()); 
    } 

    chain.doFilter(request, response); 
  } 

  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Filter initialized"); 
    this.filterConfig = filterConfig; 
  } 
}
