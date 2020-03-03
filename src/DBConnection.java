import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    protected java.sql.Connection Connect() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL ="jdbc:mysql://localhost:3306/HermannBauGmbH?";
        String dbName = "HermannBauGmbH";
        String dbUsername = "root";
        String dbPassword = "Melmwhisk98";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);

    }
}
