package comBplHRMGenericDatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con;

	public void getDBConnection(String url,String username,String password ) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(url, username, password);
	}
	
	public void closeDBConnection() throws SQLException {
		con.close();
		
	}
	
	public ResultSet executeSelectQuerry(String query) throws SQLException {
		 Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result; 
		 		 
	}
	
	public int executeNonselectQuerry(String query) throws SQLException {
		Statement statement=con.createStatement();
		 int result = statement.executeUpdate(query);
		 return result;		
	}

}
