import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import demo.Dept;
import demo.Emp;
import util.HibernateUtil;


public class InsertClient {
	static SessionFactory sf = HibernateUtil.getSessionFactory();
	public void scroll()

{
		System.out.println("scroll invoked ");
		Session session = sf.openSession();
		ScrollableResults sr = session.createQuery("select d.deptno, d.dname from demo.Dept d").scroll();
		while(sr.next())
		{
				System.out.println(sr.get()[0] +  "\t" + sr.get()[1]);
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
		}
		session.close();		
}
public void insert()
{
	Session session = null;
	Transaction tx = null;
	try{
		session = sf.openSession();
		tx = session.beginTransaction();
		
		
		for (int i = 1; i<= 100; i++)
		{
		Dept d= new Dept();
		d.setDeptno(i); 
		d.setDname("dnameof" + i); 
		d.setLoc("Pune");
	
		
		Emp e =new Emp();
		e.setEmpno(100+d.getDeptno()); e.setEname("aaa"+(d.getDeptno()+100));e.setSalary(d.getDeptno()*1000);
		e.setDepartment(d);
	
		session.persist(d);
		session.persist(e);
		
		if ((i % 20)==0)
		{
			// either flush , clear from here or config file -> jdbc.batch_size
	//		session.flush();
	//		session.clear();
			Thread.sleep(5000);
		}
		
		
	}
		
		
		
		
		tx.commit();
	}catch(Exception e)
	{
		tx.rollback();
		System.out.println("Exception in insert - " + e);
	}
	finally
	{
			session.close();
	}
}
	public static void main(String[] args) {
		InsertClient c1 = new InsertClient();
	c1.insert();
		

		//c1.scroll();	
		
	}

}

