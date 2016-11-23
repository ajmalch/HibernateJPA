import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import demo.Dept;
import demo.Emp;
import util.HibernateUtil;


public class RetriveClient {
	static SessionFactory sf = HibernateUtil.getSessionFactory();
	public void scroll()
{
		System.out.println("scroll invoked ");
		Session session = sf.openSession();
		ScrollableResults sr = session.createQuery("select d from Dept d").scroll(ScrollMode.FORWARD_ONLY);
		while(sr.next())
		{
				System.out.println(sr.get());
			}
			System.out.println("\n");
			session.close();			
		}
		
	public void scrollmodify()
{
		System.out.println("scroll invoked ");
		Session session = sf.openSession();
		ScrollableResults sr = session.createQuery("select d.deptno from Dept d").scroll(ScrollMode.FORWARD_ONLY);
		while(sr.next())
		{
				System.out.println(sr.get()[0]);
			}
			System.out.println("\n");
			session.close();			
		}
		
	
	public void list()
{
		Session session = sf.openSession();
		
		List<Dept> list = session.createQuery("select d from demo.Dept d").list();
		
		for (Dept dept : list) {
			System.out.println(dept);
			System.out.println("-------------" + dept.getEmps());
		}
		session.close();		
}
		

	public static void main(String[] args) {
		RetriveClient c1 = new RetriveClient();
	//c1.list();
		//c1.scroll();
	//	c1.scrollmodify();
		c1.list();
		
	}

}

