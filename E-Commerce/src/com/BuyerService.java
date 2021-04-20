package com;


import model.Buyer;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Path("/Buyer") 

public class BuyerService 
{ 
   Buyer BuyerObj = new Buyer(); 
   
   @POST
   @Path("/") 
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
   @Produces(MediaType.TEXT_PLAIN) 
   public String insertBuyer(@FormParam("Buyer Code") String BuyerCode, 
    @FormParam("Buyer Name") String BuyerName, 
    @FormParam("Buyer Email") String BuyerEmail, 
    @FormParam("Buyer Contact Number") Integer BuyerContactNumber,
    @FormParam("Buyer Address") String BuyerAddress)
   
   { 
	 System.out.println("Hello");  
     String output= BuyerObj.insertBuyer(BuyerCode, BuyerName, BuyerEmail, BuyerContactNumber,BuyerAddress);
     
     System.out.println(BuyerCode);
     System.out.println(BuyerName);
     return output;
   }


   @GET
   @Path("/") 
   @Produces(MediaType.TEXT_HTML) 
    public String readBuyer()
    { 
       return BuyerObj.readBuyer(); 
    }
   @PUT
   @Path("/") 
   @Consumes(MediaType.APPLICATION_JSON) 
   @Produces(MediaType.TEXT_PLAIN) 
   public String updateBuyer(String BuyerData) 
   
   { 
   //Convert the input string to a JSON object 
    JsonObject BuyerObject = new JsonParser().parse(BuyerData).getAsJsonObject(); 
   //Read the values from the JSON object
    String BuyerID = BuyerObject.get("Buyer ID").getAsString(); 
    String BuyerCode = BuyerObject.get("Buyer Code").getAsString(); 
    String BuyerName = BuyerObject.get("Buyer Name").getAsString(); 
    String BuyerEmail = BuyerObject.get("Buyer Email").getAsString(); 
    String BuyerContactNumber =BuyerObject.get("Buyer Contact Number").getAsString(); 
    String BuyerAddress =BuyerObject.get("Buyer Address").getAsString(); 
    String output = BuyerObj.updateBuyer(BuyerID,BuyerCode, BuyerName, BuyerEmail,BuyerContactNumber,BuyerAddress);
    return output;
   }
}