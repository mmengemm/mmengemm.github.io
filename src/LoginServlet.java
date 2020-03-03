import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkLogin(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/admin.jsp");
    }
    protected void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ServletException {
        DBConnection connection = new DBConnection();
        Connection c = connection.Connect();
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PreparedStatement ps;
        ps = c.prepareStatement("select username from login where username = ?");
        ps.setString(1, username);
        ResultSet rs;
        rs = ps.executeQuery();
        if (rs.next()) {
            username = rs.getString(1);
            ps = c.prepareStatement("select password from login where password = ?");
            ps.setString(1, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = c.prepareStatement("select funktion from login where username = ?");
                ps.setString(1, username);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String funktion = rs.getString(1);
                    if (funktion.equals("admin")) {
                        doGet(request,response);
                    }
                }
            }
        }
    }
}
