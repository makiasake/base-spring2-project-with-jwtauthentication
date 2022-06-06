package com.makiasake.basespring2withjwtauthentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;
import com.makiasake.basespring2withjwtauthentication.repositories.UserAccountRepository;
import com.makiasake.basespring2withjwtauthentication.services.exceptions.ObjectNotFoundException;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountRepository repository;
	
	public UserAccount findUserByEmail(String email) {
		Optional<UserAccount> userAccount = this.repository.findByEmail(email);
		
		if (userAccount.isPresent())
			return userAccount.get();
		
		throw new ObjectNotFoundException("Object not found: " + email + ", " + UserAccount.class.getName());
	}
	
}
