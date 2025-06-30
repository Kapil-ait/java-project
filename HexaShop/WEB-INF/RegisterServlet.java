import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    String user = req.getParameter("username");
    String pass = req.getParameter("password");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexashop", "root", "0506");
      PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)");
      ps.setString(1, user);
      ps.setString(2, pass);
      ps.executeUpdate();
      res.sendRedirect("login.html");
    } catch (SQLIntegrityConstraintViolationException e) {
      res.getWriter().println("Username already exists. Please choose another one.");
    } catch (Exception e) {
      e.printStackTrace(res.getWriter());
    }
  }
}
