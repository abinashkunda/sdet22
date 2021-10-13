package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc2 {

	public static void main(String[] args) throws SQLException {
		String query="insert into students values (6,'abinash','Kunda')";
				Driver driver= new Driver();
		// step1:register the connection
		DriverManager.registerDriver(driver);
		
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	
	Statement stmt = connection.createStatement();
	
	int result= stmt.executeUpdate(query);
	
	ResultSet select = stmt.executeQuery("select * from students");
	
	while(select.next()) {
		System.out.println(select.getString("RegNum")+"\t"+select.getString("FirstName")+"\t"+select.getString("LastName"));
	
	}
		connection.close();
	}
	}


