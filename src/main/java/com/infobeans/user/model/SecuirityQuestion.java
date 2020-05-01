package com.infobeans.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secuirity_question")
public class SecuirityQuestion {

	public SecuirityQuestion() {
		System.out.println("SecuirityQuestion - Constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return "SecuirityQuestion [id=" + id + ", name=" + name + "]";
	}

}
