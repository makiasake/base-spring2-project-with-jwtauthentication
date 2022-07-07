package com.makiasake.basespring2withjwtauthentication.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makiasake.basespring2withjwtauthentication.domain.UserAccount;
import com.makiasake.basespring2withjwtauthentication.dto.UserAccountDTO;
import com.makiasake.basespring2withjwtauthentication.services.UserAccountService;

@RestController
@RequestMapping("/users")
public class UserAccountResource {

	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public ResponseEntity<UserAccountDTO> getUserByEmail(@RequestParam(value = "email") String email) {
		UserAccount userAccount = this.userAccountService.findUserByEmail(email);
		return ResponseEntity.ok().body(new UserAccountDTO(userAccount));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userAccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
