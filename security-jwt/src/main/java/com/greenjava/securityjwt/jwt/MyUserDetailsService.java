package com.greenjava.securityjwt.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    //Password is password
    private String password = "$2a$10$.u4ynhKpytEE98n6sDKYMOHF6yv9mSkTwPMTsZUY9IdKP8buwR/Ca";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("sagir")) {

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));

            return new MyUserDetails(username, password, authorities);
        } else {
            throw new UsernameNotFoundException("UserName not found!");
        }

    }
}
