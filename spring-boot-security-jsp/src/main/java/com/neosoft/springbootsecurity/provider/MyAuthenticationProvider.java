package com.neosoft.springbootsecurity.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

//	public MyAuthenticationProvider() {
//		//super();
//	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		final String username = authentication.getName();
		final String password = authentication.getCredentials().toString();

		if (username.equals("sagir") && password.equals("password")) {
			
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("USER"));
			
			
			
			final UserDetails principal = new User(username, password, grantedAuths);
			
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);

			return auth;
		
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
