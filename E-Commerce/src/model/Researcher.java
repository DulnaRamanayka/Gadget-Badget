package model;

import java.sql.*; 

public class Researcher {

	private Connection connect() 
	 { 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
	 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paflab6", "root", ""); 
			System.out.println("Successfully connected");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return con; 
	 }
	
	
	public String insertItem(String code, String name, String email, int phoneNo, String category) 
	 { 
			String output = ""; 
			try
			{ 
				Connection con = connect(); 
				if (con == null) 
				{
					return "Error while connecting to the database for inserting.";
				} 
				
				
				//System.out.println("1");
				
				// create a prepared statement
				String query = " insert into researcher(`reseacherID`,`researcherCode`,`researcherName`,`Email`,`contactNo`,`projectCategory`)"
	 + " values (?, ?, ?, ?, ?, ?)"; 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				//System.out.println("2");
				
				// binding values
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, code); 
				preparedStmt.setString(3, name); 
				preparedStmt.setString(4, email); 
				preparedStmt.setInt(5, phoneNo); 
				preparedStmt.setString(6, category);
				
				
				System.out.println(code);
				System.out.println(name);
				
				//System.out.println("3");
				
				// execute the statement3
				preparedStmt.execute(); 
				
				//System.out.println("4");
				con.close(); 
				output = "Inserted successfully"; 
			} 
			catch (Exception e) 
			{ 
				output = "Error while inserting the item."; 
				e.printStackTrace();
				//System.err.println(e.getMessage()); 
			} 
			return output; 
	 } 
	
}
