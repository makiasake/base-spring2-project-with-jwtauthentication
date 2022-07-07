package com.makiasake.basespring2withjwtauthentication.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

	public Optional<UserAccount> findByEmail(String email);
	
}
