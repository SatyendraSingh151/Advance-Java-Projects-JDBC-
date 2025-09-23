package dynamic_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_View_Of_SQL_Programs {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating a statement -> PreparedStatement
		PreparedStatement ps = con.prepareStatement("select * from employee");
		
//		4.executing the query
		ResultSet rs = ps.executeQuery();
		
		
//		5. process the result (here nothing to process the result )
		while(rs.next()) {
			System.out.println(rs.getInt("empid")+" "+rs.getString("ename")+" "+rs.getString("designation")+" "+rs.getDouble("salary"));
		}
		
//		6. closing the connection
		con.close();
	}


}
