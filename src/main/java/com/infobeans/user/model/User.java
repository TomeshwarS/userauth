package com.infobeans.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	public User() {
		System.out.println("User - Constructor");
	}

	public User(String username, String firstname, String lastname, String pass, String creditcardDetails,String email) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pass = pass;
		this.creditcardDetails = creditcardDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "pass")
	private String pass;
	
	@Column(name = "creditcard_details")
	private String creditcardDetails;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCreditcardDetails() {
		return creditcardDetails;
	}

	public void setCreditcardDetails(String creditcardDetails) {
		this.creditcardDetails = creditcardDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", pass=" + pass + ", creditcardDetails=" + creditcardDetails + "]";
	}

}
