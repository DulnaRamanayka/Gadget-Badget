package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Researcher;
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

}
