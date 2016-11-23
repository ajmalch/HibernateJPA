
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.Dept;
import com.example.HibernateUtil;
import com.example.Student;


public class Client {

	public static void main(String[] args) {
		
		Session s= HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Student s1=new Student();
		s1.setName("Ajmal");
		s1.setAge(30);
		s1.setId(2);
		
		Student s2=new Student();
		s2.setName("Arun");
		s2.setAge(21);
		s2.setId(3);
		
		Student s3=new Student();
		s3.setName("Ravi");
		s3.setAge(21);
		s3.setId(4);
		
		Dept d1=new Dept();
		d1.setId(1);
		d1.setName("HR");
		d1.setLocation("Pune");
		
			
		List<Student> students1=new ArrayList<>();
		students1.add(s1);
		students1.add(s2);
		d1.setStudents(students1);
		for(Student std:students1){
			std.setDepartment(d1);
		}
		
		Dept d2=new Dept();
		d2.setId(2);
		d2.setName("Admin");
		d2.setLocation("Pune");
		
		List<Student> students2=new ArrayList<>();
		students2.add(s3);
		d2.setStudents(students2);
		for(Student std:students2){
			std.setDepartment(d2);
		}
		
		
		s.persist(d1);
		s.persist(d2);
//		s.persist(s1);
//		s.persist(s2);
//		s.persist(s3);
		tx.commit();
		s.close();
		
	}

}
