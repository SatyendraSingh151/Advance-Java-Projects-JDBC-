package All_In_One_Worker_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_Operations {
	
	public void insert() throws ClassNotFoundException, SQLException {
//		1. Load & Register Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Establishment of the Connection here
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. create statement
		Statement st = con.createStatement();		
		
//		4. execute the statement
		st.execute("insert into worker values(1,'Yuvraj','Varanasi')");
		st.execute("insert into worker values(2,'Sahil','Delhi')");
		st.execute("insert into worker values(3,'Sanjay','Patna')");
		st.execute("insert into worker values(4,'Ankit','Mumbai')");
		st.execute("insert into worker values(5,'Parth','Noida')");
		
		System.out.println("The data is inserted sucessfully into the Manager Table.");
		
//		5.process the result (here nothing to process the result)
//		6. Closing the connection
		con.close();
		
		
	}
	
	public void update() throws ClassNotFoundException, SQLException {
//		1. Load & Register Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Establishment of the Connection here
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. create statement
		Statement st = con.createStatement();		
		
//		4. execute the statement (executeUpdat() -> this method returns the int type data)
		int rows = st.executeUpdate("update worker set waddress='Gurgaon' where wid = 4");

		
		
		if(rows ==0) {
			System.out.println("No data is updated into the Manager Table.");

		}
		else {
			System.out.println(rows+ " data is updated sucessfully into the Manager Table.");

		}
		
//		5.process the result (here nothing to process the result)
//		6. Closing the connection
		con.close();
	}
	public void delete() throws ClassNotFoundException, SQLException {
//		1. Load & Register Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Establishment of the Connection here
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. create statement
		Statement st = con.createStatement();		
		
//		4. execute the statement (executeUpdat() -> this method returns the int type data)
		
		int rows = st.executeUpdate("delete from worker where wid = 2");		
		
		if(rows ==0) {
			System.out.println("No data is deleted from the Manager Table.");

		}
		else {
			System.out.println(rows+ " data is deleted sucessfully from the Manager Table.");

		}
		
//		5.process the result (here nothing to process the result)
//		6. Closing the connection
		con.close();
	}
	
	public void view() throws ClassNotFoundException, SQLException {
//		1. Load & Register Driver
		Class.forName("org.postgresql.Driver");
		
//		2. Establishment of the Connection here
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","tiger");
		
//		3. create statement
		Statement st = con.createStatement();		
		
//		4. execute the statement (executeUpdat() -> this method returns the int type data)
		ResultSet rs = st.executeQuery("select * from worker");
	
//		5.process the result (here nothing to process the result)
		while(rs.next()) {
			System.out.println(rs.getInt("wid")+" "+rs.getString("wname")+" "+rs.getString("waddress"));
		}
		
//		6. Closing the connection
		con.close();
	}

	
	

}
