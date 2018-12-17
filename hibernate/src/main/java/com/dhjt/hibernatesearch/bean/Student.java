package com.dhjt.hibernatesearch.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "c_student")
public class Student implements Serializable {

	private static final long serialVersionUID = -1583607499740601515L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	// @Column(name="s_id")
	private Integer id;
	@Column(name = "s_name")
	private String name;

	@Column(name = "birth_day")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDay;
//	@ManyToMany(targetEntity = Teacher.class)
	// 使用JoinTabl来描述中间表，并描述中间表中外键与Student,Teacher的映射关系
	// joinColumns它是用来描述Student与中间表中的映射关系
	// inverseJoinColums它是用来描述Teacher与中间表中的映射关系
//	@JoinTable(name = "s_t", joinColumns = {
//			@JoinColumn(name = "c_s_id", referencedColumnName = "id") }, inverseJoinColumns = {
//					@JoinColumn(name = "c_t_id", referencedColumnName = "id") })
//	private Set<Teacher> t = new HashSet<Teacher>();

	public Student() {
		super();
	}

	public Student(Integer id, String name, Set<Teacher> t) {
		super();
		this.id = id;
		this.name = name;
//		this.t = t;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

//	public Set<Teacher> getT() {
//		return t;
//	}
//
//	public void setT(Set<Teacher> t) {
//		this.t = t;
//	}

}
