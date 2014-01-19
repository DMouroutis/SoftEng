package auctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database Management Class that enables as to open/close SQL DB Connection
 * 
 * @author D.Mouroutis
 * @author M.Vidalis
 * @author P.Karvounopoulos
 */
public class SQLConn {

	 public static Connection sql_open()
	 {
		 Connection conn = null;
		    try {
		        // Load the JDBC driver
		        String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
		        Class.forName(driverName);

		        // Create a connection to the database
		        String url = "jdbc:mysql://localhost/auctions";
                        //DB username
		        String username = "auctions";
                        //DB user's password
		        String password = "db_admin";
		        conn = DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        // Could not find the database driver
                        System.out.println("Driver Error");
		    } catch (SQLException e) {
		        // Could not connect to the database
                        System.out.println("DB Error");
		    }
		    return conn;
	 }


	 public static int sql_close(Connection conn)
	 {
		if (conn !=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        Logger.getLogger(CreateAuction.class.getName()).log(Level.SEVERE, null, e);
                    }
		}
                return 1;
	 }

}