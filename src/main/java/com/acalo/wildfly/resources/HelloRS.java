package com.acalo.wildfly.resources;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acalo.wildfly.services.HelloEJB;


@Path("/helloRS")
public class HelloRS {

	@Inject
	HelloEJB ejb;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String saludar(){
		String text = ejb.sayHello();
		
		return "Hola Wildfly !!!!!! --- "+text;
	}
	
	
}
