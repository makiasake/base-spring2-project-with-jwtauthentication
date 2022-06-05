package com.makiasake.basespring2withjwtauthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;
import com.makiasake.basespring2withjwtauthentication.repositories.UserAccountRepository;

@SpringBootApplication
public class BaseSpring2ProjectWithJwtauthenticationApplication implements CommandLineRunner {

	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(BaseSpring2ProjectWithJwtauthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UserAccount account = new UserAccount(null, "test@gmail.com", "test", pe.encode("123"));
		userAccountRepository.save(account);		
	}

}
