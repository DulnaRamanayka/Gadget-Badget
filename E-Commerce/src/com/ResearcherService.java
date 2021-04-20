package com;

import model.Researcher; 

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
@Path("/Researchers")

public class ResearcherService {
	
	Researcher itemObj = new Researcher();
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertItem(@FormParam("researcherCode") String researcherCode, 
	 @FormParam("researcherName") String researcherName, 
	 @FormParam("Email") String Email, 
	 @FormParam("contactNo") int contactNo,
	 @FormParam("projectCategory") String projectCategory)
	
	{ 
		System.out.println("Hello");
		String output = itemObj.insertItem(researcherCode,researcherName, Email, contactNo,projectCategory); 
		
		System.out.println(researcherCode);
		System.out.println(researcherName);
		return output; 
	}
	
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readItems() 
	 { 
		return itemObj.readItems();  
	 }
	

}
