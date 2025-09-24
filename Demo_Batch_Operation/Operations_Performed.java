package Demo_Batch_Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations_Performed {
	
	public void tasks() throws ClassNotFoundException, SQLException {

		//1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");

		//2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");

		System.out.println("1 - Insert\n2 - Update\n3 - Delete");
		System.out.print("Enter your choice to perform the operation : ");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine(); // consume leftover newline

//		    initialization setAutoCommit to false
		con.setAutoCommit(false);

		//initiation of the switch case
		switch(choice) {
			case 1:{
			System.out.print("Give the no of employees you want to enter into the table : ");
			int n = sc.nextInt();
	
			//3. Statement creation
			//3.1 -> creation of the placeholder in the statement
			String insertSQL = "insert into employee(empid,ename,designation,salary) values(?,?,?,?) ";
			PreparedStatement insertps = con.prepareStatement(insertSQL);
			
			for(int i=1;i<=n;i++) {
				
				
		
				//3.2 -> taking the user input 
				System.out.print("Give the employee id : ");
				int id = sc.nextInt();
				sc.nextLine(); // consume newline after nextInt
		
				System.out.print("Give the employee name : ");
				String name = sc.nextLine();
		
				System.out.print("Give the employee designation : ");
				String designation = sc.nextLine();
		
				System.out.print("Give the employee salary : ");
				double salary = sc.nextDouble();
		
				//3.3 -> passing the value to the placeholder by the help of the setter
				insertps.setInt(1, id);
				insertps.setString(2, name);
				insertps.setString(3, designation);
				insertps.setDouble(4, salary);
		
		//		        adding the batch 
				insertps.addBatch(); // (not needed for one statement, but kept as per your comment)
			
	
				//4. executing the query
				insertps.executeUpdate();
	
			}
			//committing the connection
			con.commit();
			System.out.println("\nInsertion of the data is sucessfull\n");
	
			//closing the connection
			con.close();
			break;
	
			}
	
			case 2:{
				
			System.out.print("Give the no of employees you want to update into the table : ");
			int n = sc.nextInt();
			
			//3. Statement creation
			//3.1 -> creation of the placeholder in the statement
			String updateSQL = "update employee set designation = ?, salary =? where empid = ? ";
			PreparedStatement updateps = con.prepareStatement(updateSQL);
	
			
			for(int i=1;i<=n;i++) {
				//3.2 -> taking the user input 
				System.out.print("Give the employee id : ");
				int id = sc.nextInt();
				sc.nextLine(); // consume newline after nextInt
		
				System.out.print("Give the employee designation : ");
				String designation = sc.nextLine();
		
				System.out.print("Give the employee salary : ");
				double salary = sc.nextDouble();
		
				//3.3 -> passing the value to the placeholder by the help of the setter
				updateps.setString(1, designation);
				updateps.setDouble(2, salary);
				updateps.setInt(3, id);
		
		//		        adding the batch 
				updateps.addBatch(); // (not needed for one statement, but kept as per your comment)
		
				//4. executing the query
				updateps.executeUpdate();
	
			}
			//committing the connection
			con.commit();
			
			System.out.println("\nUpdation of the data is sucessfull\n");
	
			//closing the connection
			con.close();
			break;
	
			}
			case 3:{
				
			System.out.print("Give the no of employees you want to delete from the table : ");
			int n = sc.nextInt();
				
			//3. Statement creation
			//3.1 -> creation of the placeholder in the statement
			String deleteSQL = "delete from employee where empid = ? ";
			PreparedStatement deleteps = con.prepareStatement(deleteSQL);
	
			for(int i=1;i<=n;i++) {
				
				//3.2 -> taking the user input 
				System.out.print("Give the employee id : ");
				int id = sc.nextInt();
		
				//3.3 -> passing the value to the placeholder by the help of the setter
				deleteps.setInt(1, id);
		
		//		        adding the batch 
				deleteps.addBatch(); // (not needed for one statement, but kept as per your comment)
		
				//4. executing the query
				deleteps.executeUpdate();

			}
			
			//committing the connection
			con.commit();
			
			System.out.println("\nDeletion of the data is sucessfull\n");
	
			//closing the connection
			con.close();
			break;
	
	
			}
			default :{
			System.out.println("Sorry!, you made a wrong choice.");
	
			//committing the connection
			con.commit();
			
			System.out.println("Deletion is sucessfull\n");
	
			//closing the connection
			con.close();
			break;
			}

		}


	}

	
//	function to view the data/records
	public void view() throws ClassNotFoundException, SQLException {

		//1. Load and Register the Driver
		Class.forName("org.postgresql.Driver");

		//2. Building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");

		//3. Creating the statement
		PreparedStatement ps = con.prepareStatement("select * from employee");

		//4. Executing the query
		ResultSet rs = ps.executeQuery();

		//5. Processing the result
		while(rs.next()) {
		    System.out.println(rs.getInt("empid")+" "+rs.getString("ename")+" "+rs.getString("designation")+" "+rs.getDouble("salary"));
		}
		
		System.out.println("\nRecords of the table are sucessfull displayed.\n");
		
		//6.Closing the connection
		con.close();

		}


}
