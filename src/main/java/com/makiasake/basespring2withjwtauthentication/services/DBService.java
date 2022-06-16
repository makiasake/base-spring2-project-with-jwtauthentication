package com.makiasake.basespring2withjwtauthentication.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;
import com.makiasake.basespring2withjwtauthentication.domain.enums.Profile;
import com.makiasake.basespring2withjwtauthentication.repositories.UserAccountRepository;

@Service
public class DBService {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public void instantiateTestDatabase() {
		UserAccount account = new UserAccount(null, "admin@gmail.com", "admin", pe.encode("123"));
		account.addPerfil(Profile.ADMIN);
		
		UserAccount account1 = new UserAccount(null, "user@gmail.com", "user", pe.encode("123"));
		account1.addPerfil(Profile.USER);
		
		UserAccount account2 = new UserAccount(null, "test@gmail.com", "test", pe.encode("123"));
		account2.addPerfil(Profile.USER);
		
		userAccountRepository.saveAll(Arrays.asList(account, account1, account2));
	}
}
