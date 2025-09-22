
package All_In_One_Worker_Management;

import java.sql.SQLException;
import java.util.Scanner;
public class WorkerMainApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    CRUD_Operations worker = new CRUD_Operations();
	    Scanner sc = new Scanner(System.in);
	    boolean status = true;

	    while (status) {
	        System.out.println("1 - Insert\n2 - Update\n3 - Delete\n4 - View\n5 - Exit");
	        System.out.print("Make your choice now : ");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                worker.insert();
	                break;
	            case 2:
	                worker.update();
	                break;
	            case 3:
	                worker.delete();
	                break;
	            case 4:
	                worker.view();
	                break;
	            case 5:
	                status = false;
	                System.out.println("Thank you for using Worker Management System!");
	                break;
	            default:
	                System.out.println("Sorry! you made a wrong choice.");
	        }
	    }
	    sc.close();
	}
}