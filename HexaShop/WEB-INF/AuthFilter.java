import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter {
  public void init(FilterConfig config) {}
  public void destroy() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String uri = req.getRequestURI();

    HttpSession session = req.getSession(false);
    boolean loggedIn = (session != null && session.getAttribute("username") != null);

    boolean isLoginPage = uri.endsWith("login.html");
    boolean isRegisterPage = uri.endsWith("register.html");
    boolean isCss = uri.contains(".css");
    boolean isJs = uri.contains(".js");
    boolean isImg = uri.contains("/images/") || uri.contains(".png") || uri.contains(".jpg");

    if (loggedIn || isLoginPage || isRegisterPage || isCss || isJs || isImg) {
      chain.doFilter(request, response);
    } else {
      res.sendRedirect("login.html");
    }
  }
}
