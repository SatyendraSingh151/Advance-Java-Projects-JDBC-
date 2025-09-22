package static_sql_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingAndDisplayingValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Loading and registering the Driver
//		here forname() is the static method which is present in the Class class which is responsible for loading the Driver by getting the full address
		Class.forName("org.postgresql.Driver");
		
//		2. establish connection
//		getConnection() is the static method present in the DriverManager interface,
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. creating the statement
		Statement st  = con.createStatement();
		
//		4. execute the query -> this executeQuery() returns the ResultSet type object
		ResultSet rs = st.executeQuery("select * from employee");
		
//		this executeQuery() can only be used to display the query
		
//		5. processing the result ->  from ResultSet object -> here we will traverse by the help of next() as it checks on the cursor
//		in ResultSet interface there is already getter and the setter available
		while(rs.next()) {
			System.out.println(rs.getInt("empid")+" "+rs.getString("ename")+" "+rs.getString("designation")+" "+rs.getInt("salary"));
			
		}
		
	}

}
