package dynamic_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamic_Deletion_In_SQL_Programs {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating a statement -> PreparedStatement
//		3.1 - writing the query with placeholder
		PreparedStatement ps = con.prepareStatement("delete from employee where empid = ? ");	
//		3.2 - taking the user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id of the employee to delete : ");
		int id = sc.nextInt();
		
//		3.3 - passing the value to the placeholder
		ps.setInt(1, id);
		
//		4.executing the query
		int rows = ps.executeUpdate();
//		checking the condition
		if(rows == 0) {
			System.out.println("No data is deleted.");
		}
		else {
			System.out.println(rows + " employee data is deleted.");
		}
		
//		5. process the result (here nothing to process the result )
//		6. closing the connection
		con.close();
	}

}
