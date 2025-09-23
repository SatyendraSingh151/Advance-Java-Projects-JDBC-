package Student_Management_System_Dynamically;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_Inserting_Values_Into_The_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Making the connection
		Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. Creating the statement
//		3.1 => we will create a PreparedStatement by the help of the placeholder
		PreparedStatement ps = con.prepareStatement
				("insert into student(sid,sname,scourse,sphno) values (?,?,?,?)");
//		3.2 => now taking the user input 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the student id : ");
		int id = sc.nextInt();
		
		System.out.print("Enter the student name : ");
		String name = sc.next();
		
		System.out.print("Enter the student course : ");
		String course = sc.next();
		
		System.out.print("Enter the student Phone Number : ");
		int phno = sc.nextInt();
		
//		3.3 => now sending the data in the place of the placeholder by the help of the setter
	
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, course);
		ps.setInt(4, phno);
		
//		4. now executing the query
		ps.executeUpdate();
		
		System.out.println("The data insrtion is sucessfull.");
		
//		5. Nothing here to process the result
//		6. closing the connection
		con.close();

	}

}
