package com.jforce.lms.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jforce.lms.jwt.JwtTokenVerifier;
import com.jforce.lms.mappings.UserRole;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {
	
	Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

    private final String username;
    private final String password;
   //private final Set<? extends GrantedAuthority> authorities;
	private final List<GrantedAuthority> authorities;


    //Converting User Instance into UserDetailsImpl
//    public UserDetailsImpl(UserRole userRole){
//        this.username = userRole.getUser().getUsername();
//        this.password = userRole.getUser().getPassword();
//        this.authorities = Arrays.asList(new SimpleGrantedAuthority(userRole.getRole().getRole())); //new SimpleGrantedAuthority(user.getRole()))
//        
////        working with collection<role> in user class
////        this.authorities = user.getRole().stream()
////        		.map(role -> new SimpleGrantedAuthority(user.getRole().toString()))
////        		.collect(Collectors.toSet());
//    }
    
    public UserDetailsImpl(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole())); //new SimpleGrantedAuthority(user.getRole()))
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
