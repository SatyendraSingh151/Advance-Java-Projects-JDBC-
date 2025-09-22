package static_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Loading and registering the Driver
//		here forname() is the static method which is present in the Class class which is responsible for loading the Driver by getting the full address
		Class.forName("org.postgresql.Driver");
		
//		2. establish connection
//		getConnection() is the static method present in the DriverManager interface,
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating the statement
		Statement st  = con.createStatement();
		
//		4. executing the statement
		st.execute("insert into employee values(1,'Shella','Manager',70000)");
		st.execute("insert into employee values(2,'Ram','Hr',42000)");

		
		System.out.println("Data is inserted into the database sucessfully");
		
//		5. processing the result -> since nothing is here to give back as result because database don't return anything here
		
//		6. closing the connection
		con.close();
	}

}
