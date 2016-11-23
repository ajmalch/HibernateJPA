package util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
	private static SessionFactory sf = null;
	
	static {
		 Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");

		    ServiceRegistry serviceRegistry = 
		    		new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();

		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	private HibernateUtil()
	{
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}
	
}
