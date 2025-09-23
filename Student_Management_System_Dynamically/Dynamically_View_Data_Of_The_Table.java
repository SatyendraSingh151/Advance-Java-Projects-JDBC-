package Student_Management_System_Dynamically;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_View_Data_Of_The_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Making the connection
		Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. Creating the statement
//		3.1 => we will create a PreparedStatement by the help of the placeholder
		PreparedStatement ps = con.prepareStatement("select * from student");

		
//		4. now executing the query by the help of the executeQuery() and as it returns the ResultSet type data we will store it to use
		ResultSet rs =  ps.executeQuery();
		
//		5. processing the result
		while(rs.next()) {
			System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+rs.getString("scourse")+" "+rs.getInt("sphno"));
		}
		
		System.out.println("\nData fetching is sucessfull.");
		
//		5. closing the connection at last
		con.close();
		
		

	}

}
