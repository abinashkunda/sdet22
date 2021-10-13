package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbcwithtrycatchblock {

	public static void main(String[] args) throws SQLException {
		 Driver driver;
		 Connection connection = null;
	
		try {
			
			 driver = new Driver();
			
			DriverManager.registerDriver(driver);
			
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
			
			Statement stmt = connection.createStatement();
			
			int result = stmt.executeUpdate("delete from students where RegNum=4");
			
			ResultSet select = stmt.executeQuery("select * from students");
			while(select.next()) {
				System.out.println(select.getString("RegNum")+"\t"+select.getString("FirstName")+"\t"+select.getString("LastName"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
finally
{
	connection.close();
	System.out.println("Connection closed");
	}
	}
}
