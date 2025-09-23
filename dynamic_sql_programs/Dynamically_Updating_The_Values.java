package dynamic_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_Updating_The_Values {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating a statement -> PreparedStatement
//		3.1 - writing the query with placeholder
		PreparedStatement ps = con.prepareStatement("update employee set designation =? where empid = ?");	
//		3.2 - taking the user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the new designation : ");
		String designation = sc.next();
		System.out.print("Enter the employee id for which designation is to be changed : ");
		int id = sc.nextInt();
		
//		3.3 - passing the value to the placeholder
		ps.setString(1, designation);
		ps.setInt(2, id);
		
//    4. executing the query
		int rows = ps.executeUpdate();
		if(rows ==0) {
			System.out.println("No updation is done, because employee id does not exists.");
		}
		else {
			System.out.println(rows+ " employee details is updated.");
		}

	}

}
