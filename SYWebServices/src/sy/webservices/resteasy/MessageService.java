package sy.webservices.resteasy;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import sy.webservices.entity.User;

@Path("/symessage")
public class MessageService {
	
	@POST
	@Path("/")
	public Response printMessage(){
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		User employee = new User();
		employee.setFirstName("Yongwan");
		employee.setLastName("Shin");
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
			
		String result = "Hello World";
		return Response.status(200).entity(result).build();
	}

}
