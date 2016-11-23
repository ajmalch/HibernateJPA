

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.Student;


public class Client {

	public void create(){
		Session s= HibernateUtil.getSessionFactory().openSession();
		for(int i=0; i<10; i++){
			Student s1= new Student();
			s1.setId(10+i);
			s1.setName("Student"+i+1);
			s1.setAge(25);
			Transaction tx=s.beginTransaction();
			s.persist(s1);
			tx.commit();
		}
		
		s.close();
	}
	
	static SessionFactory sf = HibernateUtil.getSessionFactory();
	public void listprogram()
	{
			Session session = sf.openSession();
			//List<Dept> list = session.createQuery("select d from demo.Dept d where loc='Pune'").list();
			System.out.println(" -------------Listing for the first time -------------");
			Query query = session.createQuery("select d from Student d");
			query.setCacheable(true);

			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			for (Student std : list) {
				System.out.println(std);
			}
			
			System.out.println(" -------------Listing for the Second time -------------");
			Query query1 = session.createQuery("select d from Student d");
			List<Student> list1 = query1.list();
			
			for (Student std : list1) {
				System.out.println(std);
			}
			
			
			session.close();		
	}
	
	public void list()
	{
			Session session = sf.openSession();
			//List<Dept> list = session.createQuery("select d from demo.Dept d where loc='Pune'").list();
			System.out.println(" -------------Listing for the first time -------------");
			List<Student> list = session.getNamedQuery("tmp").list();
			for (Student std : list) {
				System.out.println(std);
			}
			
			System.out.println(" -------------Listing for the Second time -------------");
			List<Student> list1 = session.getNamedQuery("tmp").list();
			for (Student std : list1) {
				System.out.println(std);
			}
			
			
			session.close();		
	}
	public static void main(String[] args) throws Exception {
		Client cl = new Client();
//		cl.create();
		cl.listprogram();
		System.out.println("\n\n\n\n");
		System.out.println("sleeping ................");
		Thread.sleep(7000);
		System.out.println("sleep Over ................");
		cl.listprogram();
		
		Thread.sleep(7000);
		System.out.println("sleep Over ................");
		cl.listprogram();
		
		cl.list();
		System.out.println("\n\n\n\n");
		System.out.println("sleeping ................");
		Thread.sleep(7000);
		System.out.println("sleep Over ................");
		cl.list();
	
	}

}
