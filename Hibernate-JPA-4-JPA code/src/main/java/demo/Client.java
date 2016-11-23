package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Client {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myunit");

	public void insert(Dept d)
	{
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(d);
			tx.commit();
		}catch(Exception e)
		{
			tx.rollback();
			System.out.println("Exception in insert - " + e);
		}
		finally
		{
				em.close();
		}
	}

	public void delete(int deptno)
	{
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Dept d = em.find(Dept.class,deptno);
			em.remove(d);
			tx.commit();
		}catch(Exception e)
		{
			tx.rollback();
			System.out.println("Exception in delete - " + e);
		}
		finally
		{
				em.close();
		}
	}
	

	public void list()
	{
		EntityManager em = null;
		Query query = null;
		try{
			em = emf.createEntityManager();
			query = em.createQuery("select d from Dept d");
			
					
			List<Dept> mylist = query.getResultList();
			for (Dept dept : mylist) {
				System.out.println(dept);
			}

		}catch(Exception e)
		{
			System.out.println("Exception in List - " + e);
		}
		finally
		{
				em.close();
		}
	}
	public void update(int deptno, String newdname, String newloc)
	{
		EntityManager em = null;
		EntityTransaction tx = null;
		try{
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Dept d = em.find(Dept.class,deptno);
			d.setDname(newdname);
			d.setLoc(newloc);
			tx.commit();
		}catch(Exception e)
		{
			tx.rollback();
			System.out.println("Exception in delete - " + e);
		}
		finally
		{
				em.close();
		}
	}
	
	
	public static void main(String[] args) {
		Client cl  = new Client();
		for (int i = 1; i< 10; i++)
		{
			Dept d  = new Dept();
			d.setDeptno(i); d.setDname("dnameof"+i); d.setLoc("Hyd");
			cl.insert(d);
		}
		
		cl.delete(4);
		
		cl.update(6,"Fands","pune");
		
		cl.list();
		
		

		
	}

}
