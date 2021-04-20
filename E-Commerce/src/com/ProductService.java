package com;

import model.Product;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 
@Path("/Products")

public class ProductService {
	
	

	
Product productObj = new Product();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)

public String readProducts()
	{
		return  productObj.readProducts();
	}
	
	
	
@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertProduct
			(@FormParam("productCode") String productCode,
					@FormParam("productName") String productName,
					@FormParam("productPrice") String productPrice,
					@FormParam("productDesc") String productDesc,
					@FormParam("productRes") String productRes)
		{
			String output = productObj.insertProduct(productCode, productName, productPrice, productDesc,productRes);
			return output;
		}



	
@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateProduct(String productData)
		{
			//Convert the input string to a JSON object
			JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();
			
			//Read the values from the JSON object
			String productID = productObject.get("productID").getAsString();
			String productCode = productObject.get("productCode").getAsString();
			String productName = productObject.get("productName").getAsString();
			String productPrice = productObject.get("productPrice").getAsString();
			String productDesc = productObject.get("productDesc").getAsString();
			String productRes = productObject.get("productRes").getAsString();
			String output = productObj.updateProduct(productID, productCode, productName, productPrice, productDesc, productRes);
			
			return output;
		}
	
	
}	
	