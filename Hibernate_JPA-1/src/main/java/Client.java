

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.Student;


public class Client {

	public static void main(String[] args) {
		
		Student s1=new Student();
		s1.setName("Shadiya");
		s1.setAge(25);
		s1.setId(1);
		Session s= HibernateUtil.getSessionFactory().openSession();
		
	    Transaction tx=s.beginTransaction();
		s.persist(s1);
		tx.commit();
		s.clear();
		s.close();
		
	}

}
