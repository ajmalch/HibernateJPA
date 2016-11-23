package demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="demo4emp")
public class Emp {
	
	@Id()
	@Column(name="empnocol")
	private int empno;
	@Column(name="enameCol", length=20)
	private String ename;
	@Column(name="salcol")
	private double salary;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Dept getDepartment() {
		return department;
	}
	public void setDepartment(Dept department) {
		this.department = department;
	}

	@ManyToOne()
	@JoinColumn(name="deptnoCOL")
	private Dept department;
	
	
}
