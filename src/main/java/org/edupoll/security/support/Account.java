package org.edupoll.security.support;

import java.util.Collection;
import java.util.List;

import org.edupoll.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Account implements UserDetails{
	
	User entity;

	public Account(User entity) {
		this.entity = entity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(entity.getAuthority()));
	}

	@Override
	public String getPassword() {
		return entity.getPass();
	}

	@Override
	public String getUsername() {
		return entity.getId();
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
