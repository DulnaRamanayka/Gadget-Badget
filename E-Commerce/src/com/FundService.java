package com;

import model.Fund;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 
@Path("/Fund")

public class FundService {
	
	
Fund fundObj = new Fund();

@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)

public String readFunds()
	{
		return  fundObj.readFunds();
	}
	
	
	
@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)

public String insertFund(@FormParam("fundTotalAmount") String fundTotalAmount,
			@FormParam("fundPrecentage") String fundPrecentage,
			@FormParam("fundTime") String fundTime,
			@FormParam("fundDate") String fundDate)
		{
			String output = fundObj.insertFund(fundTotalAmount, fundPrecentage, fundTime, fundDate);
			return output;
		}



	
@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateFund(String fundData)
		{
			//Convert the input string to a JSON object
			JsonObject fundObject = new JsonParser().parse(fundData).getAsJsonObject();
			
			//Read the values from the JSON object
			String fundID = fundObject.get("fundID").getAsString();
			String fundTotalAmount = fundObject.get("fundTotalAmount").getAsString();
			String fundPrecentage = fundObject.get("fundPrecentage").getAsString();
			String fundTime = fundObject.get("fundTime").getAsString();
			String fundDate = fundObject.get("fundDate").getAsString();
			
			String output = fundObj.updateFund(fundID, fundTotalAmount, fundPrecentage, fundTime, fundDate);
			return output;
		}



@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)

public String deleteFund(String fundData)
	{
	
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(fundData, "", Parser.xmlParser());

		//Read the value from the element <productID>
		String fundID = doc.select("fundID").text();
		String output = fundObj.deleteFund(fundID);
		return output;
	}
	
	
	
}