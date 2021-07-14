package com.jforce.lms.model;

public class Role {
	
	private String role;

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}
}
