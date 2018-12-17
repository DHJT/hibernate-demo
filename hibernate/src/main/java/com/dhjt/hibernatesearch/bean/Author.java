package com.dhjt.hibernatesearch.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "T_AUTHOR")
public class Author implements Serializable {

	private static final long serialVersionUID = 9103377100953469934L;

	@Id
	@GeneratedValue
	private Integer id;

	@Field
	@Column(name = "name")
	private String name;

	public Author() {
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
}
