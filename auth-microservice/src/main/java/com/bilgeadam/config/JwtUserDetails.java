package com.bilgeadam.config;

import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {
    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails getUserByAuthId(Long authid){
        Optional<Auth> auth = authService.findById(authid);
        if (auth.isEmpty()) return null;
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(auth.get().getRole().toString()));

        return User.builder()
                .username(auth.get().getEmail())
                .password(auth.get().getPassword())
                .accountLocked(false)
                .accountExpired(false)
                .authorities(authorities)
                .build();
    }
}