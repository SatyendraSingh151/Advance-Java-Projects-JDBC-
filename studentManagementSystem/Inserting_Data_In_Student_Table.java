package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserting_Data_In_Student_Table {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//.1 Load and Register the Driver
		Class.forName("org.postgresql.Driver");
		
//		2. building the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
		
//		3. creation of the statement
		Statement st = con.createStatement();
		
//		4. Executing the statement
		st.execute("insert into student values(1,'Satya','B.Tech',800456)");
		st.execute("insert into student values(2,'Ram','B.Pharma',548676)");
		st.execute("insert into student values(3,'Sita','Dipolma',123456)");
		st.execute("insert into student values(4,'Nancy','B.Tech',830360)");
		st.execute("insert into student values(5,'Satyendra','B.Pharma',856479)");
		st.execute("insert into student values(6,'Gautam','Dipolma',987654)");


		
//		5. Processing the result -> (since nothing is here to process)
		
		
//		printing a message
		System.out.println("The data is inserted in the table sucessfully.");
		
//		6. Closing the connection
		con.close();

	}

	
}
