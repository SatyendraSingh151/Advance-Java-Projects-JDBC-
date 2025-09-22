package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Displaying_The_Stored_Data_Of_Existing_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Loading & Registering the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Establishing the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");

//		3. Statement creation
		Statement st = con.createStatement();
		
//		4. executing the statement by the help of executeQuery()-> this method returns the ResultSet type data
		ResultSet rs = st.executeQuery("select * from student");
		
		
//		processing the result here (to access each and every record here we will run a loop)
		while(rs.next()) {
			System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+rs.getString("scourse")+" "+ rs.getInt("sphno"));
		}
		
//		6. Closing the connection
		con.close();
	}

}
