package sy.webservices.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/symessage")
public class MessageService {
	
	@GET
	@Path("/")
	public Response printMessage(){
		String result = "Hello World";
		return Response.status(200).entity(result).build();
	}

}
