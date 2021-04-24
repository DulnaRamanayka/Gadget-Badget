package model;
import java.sql.*;



public class Fund {
	//A common method to connect to the DB
	   private Connection connect() 
	     { 
	       Connection con = null; 
	   try
	     { 
	     Class.forName("com.mysql.jdbc.Driver"); 

	      //Provide the correct details: DBServer/DBName, username, password 
	     con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fund_tt?serverTimezone=UTC", "root", ""); 
	     
	     System.out.println("sucessfully connected");
	     } 
	    catch (Exception e) 
	    {e.printStackTrace();} 
	     return con; 
	    }
	
	
public String insertFund(String totalAmount, String precentage, String time, String date) {
		{
			String output = "";
			try
			{
				
			Connection con = connect();

			if (con == null){
				
				return "Error while connecting to the database for inserting."; 
				
			}
			// create a prepared statement
					String query = " insert into fund_tt(`fundId`,`fundTotalAmount`,`fundPrecentage`,`fundTime`,`fundDate`)"
			                 + " values (?, ?, ?, ?, ?)";


					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, totalAmount);
					preparedStmt.setString(3, precentage);
					preparedStmt.setString(4, time);
					preparedStmt.setString(5, date);

					
					//execute the statement
					
					preparedStmt.execute();
					con.close();
					output = "Inserted successfully";
					}
					
					
					catch (Exception e)
					{
						output = "Error while inserting the fund...";
						System.err.println(e.getMessage());
					}
					
					return output;
				}

		}


public String readFunds() {
		
			
		String output = "";
		try
		{
					
			Connection con = connect();
			if (con == null){
					return "Error while connecting to the database for Fund reading.";
				}
					
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Fund TotalAmount</th>" +
						"<th>Fund Precentage</th>" +
						"<th>Fund Time</th>" +
						"<th>Fund Date</th>" +
						"<th>Update</th><th>Remove</th></tr>";
					
				String query = "select * from fund_tt";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
					
				// iterate through the rows in the result set
				while (rs.next())
					{
						
					String fundID = Integer.toString(rs.getInt("fundID"));
					String fundTotalAmount = rs.getString("fundTotalAmount");
					String fundPrecentage = rs.getString("fundPrecentage");
					String fundTime = rs.getString("fundTime");
					String fundDate = rs.getString("fundDate");
					
						
					// Add into the html table
					output += "<tr><td>" + fundTotalAmount + "</td>";
					output += "<td>" + fundPrecentage + "</td>";
					output += "<td>" + fundTime + "</td>";
					output += "<td>" + fundDate + "</td>";
					
						
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
							+ "<td><form method='post' action='product.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							+ "<input name='fundID' type='hidden' value='" + fundID
							+ "'>" + "</form></td></tr>";
						}
					con.close();
					// Complete the html table
					output += "</table>";
				}
				catch (Exception e)
				{
					output = "Error while reading the fund.";
					System.err.println(e.getMessage());
				}
				
			return output;
		}


public String updateFund(String ID, String totalAmount, String precentage, String time, String date)
{
	 String output = "";
	 try{
		 
		 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for updating.";
			 
		 }
		// create a prepared statement
			String query = "UPDATE fund_tt SET fundTotalAmount=?,fundPrecentage=?,fundTime=?,fundDate=?"
					+ "WHERE fundID=?";
					
			
			
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    	 
				 
			 // binding values
		    preparedStmt.setString(1, totalAmount);
			preparedStmt.setString(2, precentage);
			preparedStmt.setString(3, time);
			preparedStmt.setString(4, date);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			 	
				// execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Updated successfully";
				 
	 }
	 	catch (Exception e)
	 	{
	 		output = "Error while updating the Fund.";
	 		System.err.println(e.getMessage());
	 	}
	 	return output;
	}



public String deleteFund(String fundID)
{
	String output = "";
	try
	{
		Connection con = connect();
		if (con == null)
			
		{	
			return "Error while connecting to the database for deleting.";
	
		}
		
		// create a prepared statement
		 String query = "delete from fund_tt where fundID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 int fundId = Integer.parseInt(fundID);
		 
		// binding values
		 preparedStmt.setInt(1, fundId);
		 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 
	}
	
		catch (Exception e)
		{
		
			output = "Error while deleting the Fund.";
			System.err.println(e.getMessage());
		}
 
		return output;
 
 
		}


}