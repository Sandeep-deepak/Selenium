package MySQL_DBTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class xamppMySql {

	public static void main(String[] args) throws SQLException {
		// opencart database testing from Apache Xampp MySQL
		// No password for this Database
		
		// 1) Create a Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opencart", "root", "");
		
		// 2) Create Statement/ Query
		Statement stmt = con.createStatement();
		String query = "SELECT * FROM oc_customer;";
		
		// 3) Execute Statement/Query & 4) Store data in ResultSet
		ResultSet rs = stmt.executeQuery(query); // Contains data of table
		
		System.out.println("Customer ID" + " | " + "First Name" + " | " + "Last Name" + " | " + "Email" + " | " + "Telephone" + " | " + "Date Added");
		System.out.println("--------------------------------------------------");
		while(rs.next()) {
			int cust_id = rs.getInt("customer_id"); // Store employeeNumber in emp_num variable
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			String email = rs.getString("email");
			String tele = rs.getString("telephone");
			String dateAdded = rs.getString("date_added");
					
			
			System.out.println(cust_id + " | " + fname + " | " + lname + " | " + email + " | " + tele + " | " + dateAdded);
		}

		// Close Connection
		con.close();
		
		System.out.println("Query Executed...");
	}

}
