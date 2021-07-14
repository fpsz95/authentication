package com.jforce.lms.mappings;

import com.jforce.lms.model.Role;
import com.jforce.lms.user.User;

public class UserRole {
	private final User user;
	private final Role role;

	public UserRole(User user, 
			Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserRole [user=" + user + ", role=" + role + "]";
	}
}
