package sy.webservices.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path("/symessage")
public class MessageService {
	
	@GET
	@Path("/")
	public Response printMessage(){

		// add user
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        Employee emp = new Employee();
        emp.setName("Deepak Kumar");
        session.save(emp);
        tr.commit();
        System.out.println("Successfully inserted");
        sessFact.close();
        
        
		String result = "Hello World";
		return Response.status(200).entity(result).build();
	}

}
