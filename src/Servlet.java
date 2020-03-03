import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    private SQLInsertions sqlInsertions = new SQLInsertions();

    public Servlet() throws SQLException, ClassNotFoundException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("hidden"));
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("hidden")) {
            case "neuer Mitarbeiter erstellen": {
                RequestDispatcher rd = request.getRequestDispatcher("/mitarbeiter.jsp");
                rd.include(request, response);
                break;
            }
            case "neue Baustelle erstellen": {
                RequestDispatcher rd = request.getRequestDispatcher("/baustellen.jsp");
                rd.include(request, response);
                break;
            }
            case "neuer Kunde erstellen": {
                RequestDispatcher rd = request.getRequestDispatcher("/kunden.jsp");
                rd.include(request, response);
                break;
            }
            case "Mitarbeiter jetzt erstellen": {
                String vorname =  request.getParameter("Vorname");
                String nachname =  request.getParameter("Nachname");
                String adresse =  request.getParameter("Adresse");
                String email =  request.getParameter("Email");
                String ahv =  request.getParameter("AHV");
                try {
                    sqlInsertions.mitarbeiter_inserts(vorname, nachname, adresse, email, ahv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "Kunde jetzt erstellen": {
                String kunde =  request.getParameter("Kunde");
                String adresse =  request.getParameter("Adresse");
                String email =  request.getParameter("Email");
                try {
                    sqlInsertions.kunden_inserts(kunde, adresse, email);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "Baustelle jetzt erfassen": {
                Connection c = null;
                response.setContentType("text/html");
                String sql = "select Kunde from Kunden";
                DBConnection dbConnection = new DBConnection();
                try {
                    c = dbConnection.Connect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ResultSet rs = null;
                PreparedStatement ps = null;
                try {
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("rsvalue", rs);
            }
        }
    }
}
