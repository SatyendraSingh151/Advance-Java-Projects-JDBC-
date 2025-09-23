package dynamic_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_Inserting_Values {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. Statement creation -> for dynamic SQL query we use PreparedStatement interface
//		3.1 create dynamic SQL query using the place holders (? this will be the placeholder which will reserve the space to put the value)
		PreparedStatement ps =  con.prepareStatement
								("insert into employee values(?,?,?,?)");

//		3.2 taking the input from the user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the employee id : ");
		int id = sc.nextInt();
		System.out.print("Enter the employee name : ");
		String name = sc.next();
		System.out.print("Enter the employee designation : ");
		String designation = sc.next();
		System.out.print("Enter the employee salary : ");
		double salary = sc.nextDouble();
		
//		3.3 set the user given value in the placeholder (i.e in the place of ? )
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, designation);
		ps.setDouble(4, salary);
		
//		4. execute the query
		ps.executeUpdate();
		System.out.println("Insertion is done sucessfully.");
		
//		5. process the result
//		6. closing the connection
		con.close();
		
	}

}
