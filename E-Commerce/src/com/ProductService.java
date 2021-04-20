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
	
}	
	