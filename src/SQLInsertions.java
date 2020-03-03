import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLInsertions extends DBConnection{
    private Connection c;
    SQLInsertions() throws SQLException, ClassNotFoundException {
        this.c = super.Connect();
    }


    public void mitarbeiter_inserts(String vorname, String nachname, String adresse, String email, String ahv) throws SQLException {
        ResultSet rs;
        PreparedStatement ps;
        ps = c.prepareStatement("select Vorname, Nachname from Arbeiter where Vorname = ? and Nachname = ?");
        ps.setString(1,vorname);
        ps.setString(2,nachname);
        rs = ps.executeQuery();
        if(!rs.next()) {
            ps = c.prepareStatement("insert into Arbeiter(Vorname, Nachname, Adresse, Mail, AHVNr) values (?,?,?,?,?)");
            ps.setString(1, vorname);
            ps.setString(2, nachname);
            ps.setString(3, adresse);
            ps.setString(4, email);
            ps.setString(5, ahv);
            ps.executeUpdate();
        }
    }
    public void kunden_inserts(String kunde, String adresse, String email) throws SQLException {
        PreparedStatement ps;
        ps = c.prepareStatement( "insert into Kunden (Kunde, Adresse, mail)" + " values (?,?,?)");
        ps.setString(1,kunde);
        ps.setString(2,adresse);
        ps.setString(3,email);
        ps.executeUpdate();
    }

}
