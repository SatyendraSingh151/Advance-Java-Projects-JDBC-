package static_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatingValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Loading and registering the Driver
//		here forname() is the static method which is present in the Class class which is responsible for loading the Driver by getting the full address
		Class.forName("org.postgresql.Driver");
		
//		2. establish connection
//		getConnection() is the static method present in the DriverManager interface,
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating the statement
		Statement st  = con.createStatement();
		
//		4. executing the statement, since executeUpdate() is giving the int type return value
		int rows = st.executeUpdate("update employee set salary=95000 where designation='Manager'"); 
		

		if(rows ==0) {
			System.out.println("Updation is not done");
			
		}
		else {
			System.out.println(rows+" Employee salary is updated");
		}
		
//		6. closing the connection
	}

}
