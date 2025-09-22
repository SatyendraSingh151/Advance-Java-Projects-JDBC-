package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updating_The_Values_In_The_Existing_Student_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//.1 Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");

		
//		3. creation of the statement
		Statement st = con.createStatement();
		
//		4. execute the statement
		int rows = st.executeUpdate("update student set sphno = 980100 where sid = 3");
		
//		checking the condition for the return type of the executeUpdate() as it is int type
		if(rows ==0) {
			System.out.println("There is no change in the stored data.");
		}
		else {
			System.out.println(rows+ " Student phnoe no is updated");
		}
		

	}

}
