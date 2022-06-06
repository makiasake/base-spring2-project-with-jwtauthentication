package com.makiasake.basespring2withjwtauthentication.dto;

import java.io.Serializable;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;

public class UserAccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	
	public UserAccountDTO() {}

	public UserAccountDTO(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserAccountDTO(UserAccount userAccount) {
		this.id = userAccount.getId();
		this.name = userAccount.getName();
		this.email = userAccount.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
