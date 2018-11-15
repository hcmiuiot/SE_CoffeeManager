import javafx.scene.image.Image;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbHandler extends Configs {
	private static DbHandler instance;
	private static Connection conn;
    private static Statement statement;

    public static DbHandler getInstance() {
    	if (instance == null) {
    		instance = new DbHandler();
    		instance.getConnection();
    	}
    	return instance;
    }
    public static ResultSet ExecSQL(String sql) {
    	try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
    	return null;
    }

    public static Connection getConnection() {
        String ConnectionString = "jdbc:mysql://" + Configs.dbHostname + ":" + Configs.dbPort + "/" + Configs.dbName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(ConnectionString, Configs.dbUsername, Configs.dbPassword);
            statement = conn.createStatement();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
        return conn;
    }
}