package com.infobeans.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jwt_conf")
public class JwtConfiguration {

	public JwtConfiguration() {

		System.out.println("JwtConfiguration -Constructor ");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "secret_key")
	private String secretKey;

	@Column(name = "token_validity")
	private Long tokenValidity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Long getTokenValidity() {
		return tokenValidity;
	}

	public void setTokenValidity(Long tokenValidity) {
		this.tokenValidity = tokenValidity;
	}

	@Override
	public String toString() {
		return "JwtConfiguration [id=" + id + ", secretKey=" + secretKey + ", tokenValidity=" + tokenValidity + "]";
	}

}
