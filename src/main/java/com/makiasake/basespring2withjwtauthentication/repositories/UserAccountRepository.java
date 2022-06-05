package com.makiasake.basespring2withjwtauthentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

	@Transactional(readOnly = true)
	public UserAccount findByEmail(String email);
	
}
