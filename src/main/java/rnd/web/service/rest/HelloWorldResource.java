package rnd.web.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld/")
public class HelloWorldResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	//@Path("/")
	public String getHello() {
		return "Hello World";
	}

}
