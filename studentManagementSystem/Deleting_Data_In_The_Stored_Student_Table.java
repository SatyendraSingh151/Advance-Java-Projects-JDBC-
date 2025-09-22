package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Deleting_Data_In_The_Stored_Student_Table {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//.1 Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");

		
//		3. creation of the statement
		Statement st = con.createStatement();
		
//		4. execution of the statement (here executeUpdate() returns the int type data
		int rows = st.executeUpdate("delete from student where sid = 4");
	
//		checking the condition
		if(rows ==0) {
			System.out.println("No data of student is deleted.");
		}
		else {
			System.out.println(rows+" Student data is deleted.");
		}
		
//		5. process the result ( since nothing to process)
		
//		6. Closing the connection
		con.close();
		

		
	}

}
