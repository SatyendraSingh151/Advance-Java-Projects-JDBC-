package Batch_Operations_For_Employee_Management_System;

import java.sql.SQLException;
import java.util.Scanner;

public class Main_Control {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		making the object reference for the class which have the batch operation defined
		Operations_Perfoemed ref = new Operations_Perfoemed();
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean status = true;
		
		while(status) {
			System.out.println("1 - Perform operations\n2 - View records\n3 - Exit");

			System.out.print("Give the choice to perform the action : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				ref.operations();
				break;
			}
			case 2:{
				ref.view();
				break;
			}
			case 3:{
				status = false;
				System.out.println("Thank you for using the Employee Management System.");
				break;
			}
			default:{
				System.out.println("Opps! you made a wrong choice.");
			}
			}
		}
		
		

	}

}
