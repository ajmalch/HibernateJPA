package com.example;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Column
	private Integer age;
	@Column
	private String name;
	@Id
	private Integer id;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=Dept.class )
	Dept department= new Dept();
	
	public Dept getDepartment() {
		return department;
	}
	public void setDepartment(Dept department) {
		this.department = department;
	}
	
	


}
