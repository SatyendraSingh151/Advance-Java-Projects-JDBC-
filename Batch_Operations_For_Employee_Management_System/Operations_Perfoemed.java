package Batch_Operations_For_Employee_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations_Perfoemed {
	
	public void operations() throws ClassNotFoundException, SQLException {
//		1.Loading and Registering the Driver
	    Class.forName("org.postgresql.Driver");
	    
//	    2. Establishing the connection
	    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
	    
//	    setting the setAutoCommit(false)
	    con.setAutoCommit(false);
	    
	    Scanner sc = new Scanner(System.in);

	    // Inserting the data into the table
	    String insertSql = "insert into employee(empid,ename,designation,salary) values (?,?,?,?)";
	    PreparedStatement insertPs = con.prepareStatement(insertSql);
	    
//	    taking the user input to put in the place of the placeholder
	    System.out.println("Give the details to insert the data.");
	    System.out.print("Enter the employee id : ");
	    int id = sc.nextInt();
	    System.out.print("Enter the employee name : ");
	    String name = sc.next();
	    System.out.print("Enter the employee designation : ");
	    String designation =  sc.next();
	    System.out.print("Enter the employee salary : ");
	    double salary = sc.nextDouble();
	    
//	    sending the data to the placeholder
	    insertPs.setInt(1, id);
	    insertPs.setString(2, name);
	    insertPs.setString(3, designation);
	    insertPs.setDouble(4, salary);
	    
	    insertPs.addBatch();
	    
	    System.out.println();

	    // Updating the data in the records
	    String updateSql = "update employee set designation = ? , salary = ? where empid = ?";
	    PreparedStatement updatePs = con.prepareStatement(updateSql);
	    
//	    taking the user input
	    System.out.println("Give the details to update the data in the Employee.");
	    System.out.print("Enter the employee designation : ");
	    designation =  sc.next();
	    System.out.print("Enter the employee salary : ");
	    salary = sc.nextDouble();
	    System.out.print("Enter the employee id : ");
	    id = sc.nextInt();

//	    passing the value to the placeholder
	    updatePs.setString(1, designation);
	    updatePs.setDouble(2, salary);
	    updatePs.setInt(3, id);
	    updatePs.addBatch();
	    
	    System.out.println();

	    // Deleting the record of the table
	    String deleteSql = "delete from employee where empid = ?";
	    PreparedStatement deletePs = con.prepareStatement(deleteSql);
	    
//	    taking the user input
	    System.out.print("Give the employee id to delete the record : ");
	    id = sc.nextInt();
	    
//	    sending the data to the placeholder
	    deletePs.setInt(1, id);
	    deletePs.addBatch();

	    // Execute all batches
	    insertPs.executeBatch();
	    updatePs.executeBatch();
	    deletePs.executeBatch();

	    con.commit();
	    
//	    closing the connection
	    con.close();
	    System.out.println();
	}

	
//	defining the view function
	public void view() throws ClassNotFoundException, SQLException {
		System.out.println();
//		1. Loading and Registering the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Building the connection between java program and the database
		Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. Now we will create a statement with the help of PreparedStatement interface
		
		PreparedStatement ps = con.prepareStatement("select * from employee");
		
//		4. executing the query
		ResultSet rs = ps.executeQuery();
		
//		5. processing the result
		while(rs.next()) {
			System.out.println(rs.getInt("empid")+" "+rs.getString("ename")+" "+rs.getString("designation")+" "+rs.getDouble("salary"));
			
		}
		
//		6. closing the connection
		con.close();
		System.out.println();
	}

}
