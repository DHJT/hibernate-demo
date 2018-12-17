package com.dhjt.hibernatesearch.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "c_teacher")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 6130810757355130115L;
	@Id
	@GenericGenerator(name = "myuuid", strategy = "uuid")
	@GeneratedValue(generator = "myuuid") // 引入自定义主键生成策略
	// @Column(name="t_id")
	private String id;
	@Column(name = "t_name")
	private String name;

//	@ManyToMany(targetEntity = Student.class, mappedBy = "t") // 让student维护外键表
//	@ManyToMany(mappedBy = "t")
//	@Cascade(CascadeType.ALL)
//	@Fetch(FetchMode.JOIN)
	@ManyToMany
	private Set<Student> students = new HashSet<Student>();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String id, String name, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}