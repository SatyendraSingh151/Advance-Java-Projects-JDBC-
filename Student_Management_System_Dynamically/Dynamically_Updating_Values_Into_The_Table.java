package Student_Management_System_Dynamically;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamically_Updating_Values_Into_The_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Making the connection
		Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. Creating the statement
//		3.1 => we will create a PreparedStatement by the help of the placeholder
		PreparedStatement ps = con.prepareStatement
				("update student set scourse = ? where sid = ? ");
//		3.2 => now taking the user input 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the new course to update of the student : ");
		String course = sc.next();
		
		System.out.print("Enter the student id : ");
		int id = sc.nextInt();
		
//		3.3 => now sending the data to the placeholder through the ps object reference by using the setter
		ps.setString(1, course);
		ps.setInt(2, id);
		
//		4. now executing the query by the help of the executeUpdate()
		ps.executeUpdate();
		
		System.out.println("Updation is done sucessfully");
		
//		5. nothing here to process the result
//		5. closing the connection at last
		con.close();
		
		

	}

}
