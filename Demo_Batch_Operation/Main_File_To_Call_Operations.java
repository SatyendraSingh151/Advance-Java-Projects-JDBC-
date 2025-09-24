package Demo_Batch_Operation;

import java.sql.SQLException;
import java.util.Scanner;

public class Main_File_To_Call_Operations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		making the object reference of the class which has all the operations defined in it
		Operations_Performed ref = new Operations_Performed();
		
		Scanner sc = new Scanner(System.in);

		boolean status = true;
		while(status) {
			System.out.println("1 - Operations\n2 - View records\n3 - Exit");
			System.out.print("Enter your choice to perform the action : ");
			int choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
				case 1:{
					ref.tasks();
					break;
				}
				case 2:{
					ref.view();
					break;
				}
				case 3:{
					status = false;
					System.out.println("Thank you for using this Employee Management System.");
					break;
				}
				default :{
					System.out.println("Opps!, you made a wrong choice, Please try again.");
				}
			}
			
		}

	}

}
