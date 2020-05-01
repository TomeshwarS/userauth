package com.infobeans.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "secuirity_answer")
public class SecuirityAnswer {

	public SecuirityAnswer() {

		System.out.println("SecuirityAnswer-- Consructor ");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SecuirityQuestion.class)
	@JoinColumn(name = "ques_id", referencedColumnName = "id")
	List<SecuirityQuestion> secuirityQuestions;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SecuirityQuestion> getSecuirityQuestions() {
		return secuirityQuestions;
	}

	public void setSecuirityQuestions(List<SecuirityQuestion> secuirityQuestions) {
		this.secuirityQuestions = secuirityQuestions;
	}

	@Override
	public String toString() {
		return "SecuirityAnswer [id=" + id + ", name=" + name + ", user=" + user + ", secuirityQuestions="
				+ secuirityQuestions + "]";
	}

}
