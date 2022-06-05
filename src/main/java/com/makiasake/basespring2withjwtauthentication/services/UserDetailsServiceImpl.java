package com.makiasake.basespring2withjwtauthentication.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;
import com.makiasake.basespring2withjwtauthentication.repositories.UserAccountRepository;
import com.makiasake.basespring2withjwtauthentication.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserAccount userAccount = userAccountRepository.findByEmail(email);

		if (Objects.isNull(userAccount)) {
			throw new UsernameNotFoundException(email);
		}

		return new UserSS(userAccount.getId(), userAccount.getEmail(), userAccount.getPassword(),
				userAccount.getProfiles());
	}

}
