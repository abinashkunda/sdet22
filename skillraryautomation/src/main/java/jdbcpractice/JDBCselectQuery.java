package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCselectQuery {

	public static void main(String[] args) throws SQLException {
		//Load the database driver
		Driver driver= new Driver();
		// step1:register the connection
		DriverManager.registerDriver(driver);
		
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	
	Statement stmt = connection.createStatement();
	
	ResultSet result = stmt.executeQuery("select * from students");
	
	while(result.next()) {
		System.out.println(result.getInt(1)+"\t"+result.getString("FirstName")+"\t"+result.getString("LastName"));
	
	}
		connection.close();
	}

	

}
