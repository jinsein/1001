package sy.webservices.resteasy;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
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
		
		Query query = session.createQuery("from User where id = :id ");
		query.setParameter("id", 1l);
		User user = (User)query.list().get(0);
		
		/*
		User employee = new User();
		employee.setFirstName("Yongwan");
		employee.setLastName("Shin");
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		*/
		
		String result = "Hello World " + user.getFirstName() + " " + user.getLastName();
		return Response.status(200).entity(result).build();
	}

}
