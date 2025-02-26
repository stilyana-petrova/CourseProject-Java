import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

static Connection conn=null;
	
	static Connection GetConnection() {
		 try {
	            String url = "jdbc:sqlserver://localhost:1433;databaseName=musicalShop;integratedSecurity=true;encrypt=false";
	            conn = DriverManager.getConnection(url);
	            System.out.println("Connected to SQL Server successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Connection failed! Check your SQL Server settings.");
	        }
	        return conn;
	}
}
