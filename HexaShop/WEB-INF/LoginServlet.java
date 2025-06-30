import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    String user = req.getParameter("username");
    String pass = req.getParameter("password");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexashop", "root", "0506");
      PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
      ps.setString(1, user);
      ps.setString(2, pass);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        HttpSession session = req.getSession();
        session.setAttribute("username", user);
        res.sendRedirect("index.html");
      } else {
        res.sendRedirect("login.html");
      }
    } catch (Exception e) {
      e.printStackTrace(res.getWriter());
    }
  }
}
