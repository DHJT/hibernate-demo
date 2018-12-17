package com.dhjt.hibernatesearch.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6755135112403601451L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "salary")
	private Integer salary;

	public Employee() {
	}

	public Employee(String fname, String lname, Integer salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

}
