package com.jforce.lms.user;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.jforce.lms.model.Role;

@Component
public class User {
	private String username; 
	private String firstname; 
	private String lastname;
	private String password;
	private String enabled;
	private String createdDate;
	private String createdBy;
	private String lastModifiedDate;
	private String lastModifiedBy;
	private String enrollmentYear;
	private String enrollmentMonth;
	private String active;
	private String validityEndYear;
	private String validityEndMonth;
	private String fatherName;
	private String motherName;
	private Integer programId;	
	private String email;
	private Double mobile;
	private String attempts;
	private String acadSession;
	private String type;
	private String rollNo;
	private String campusId;
	private String campusName;
	private String deRegStatus;
	private String deRegReason;
	private String address;
	private String prgNameToShow;
	private String role;
	
	public User() {
		super();
	}

	public User(
			String username, 
			String firstname, 
			String lastname, 
			String password, 
			String enabled, 
			String createdDate,
			String createdBy, 
			String lastModifiedDate, 
			String lastModifiedBy, 
			String enrollmentYear,
			String enrollmentMonth, 
			String active, 
			String validityEndYear, 
			String validityEndMonth, 
			String fatherName,
			String motherName, 
			Integer programId, 
			String email, 
			Double mobile, 
			String attempts, 
			String acadSession,
			String type, 
			String rollNo, 
			String campusId, 
			String campusName, 
			String deRegStatus, 
			String deRegReason,
			String address, 
			String prgNameToShow, 
			String role) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.enabled = enabled;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.enrollmentYear = enrollmentYear;
		this.enrollmentMonth = enrollmentMonth;
		this.active = active;
		this.validityEndYear = validityEndYear;
		this.validityEndMonth = validityEndMonth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.programId = programId;
		this.email = email;
		this.mobile = mobile;
		this.attempts = attempts;
		this.acadSession = acadSession;
		this.type = type;
		this.rollNo = rollNo;
		this.campusId = campusId;
		this.campusName = campusName;
		this.deRegStatus = deRegStatus;
		this.deRegReason = deRegReason;
		this.address = address;
		this.prgNameToShow = prgNameToShow;
		this.role = role;
	}

	public User(
			String username,
			String password,
			String firstname, 
			String lastname, 
			String email,
			String role
			) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}
	
	public User(
			String username,
			String firstname, 
			String lastname, 
			String email
			) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public User(
			String username,
			String password, 
			String role
			) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(String enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public String getEnrollmentMonth() {
		return enrollmentMonth;
	}

	public void setEnrollmentMonth(String enrollmentMonth) {
		this.enrollmentMonth = enrollmentMonth;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getValidityEndYear() {
		return validityEndYear;
	}

	public void setValidityEndYear(String validityEndYear) {
		this.validityEndYear = validityEndYear;
	}

	public String getValidityEndMonth() {
		return validityEndMonth;
	}

	public void setValidityEndMonth(String validityEndMonth) {
		this.validityEndMonth = validityEndMonth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getMobile() {
		return mobile;
	}

	public void setMobile(Double mobile) {
		this.mobile = mobile;
	}

	public String getAttempts() {
		return attempts;
	}

	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}

	public String getAcadSession() {
		return acadSession;
	}

	public void setAcadSession(String acadSession) {
		this.acadSession = acadSession;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getCampusId() {
		return campusId;
	}

	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getDeRegStatus() {
		return deRegStatus;
	}

	public void setDeRegStatus(String deRegStatus) {
		this.deRegStatus = deRegStatus;
	}

	public String getDeRegReason() {
		return deRegReason;
	}

	public void setDeRegReason(String deRegReason) {
		this.deRegReason = deRegReason;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrgNameToShow() {
		return prgNameToShow;
	}

	public void setPrgNameToShow(String prgNameToShow) {
		this.prgNameToShow = prgNameToShow;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", enabled=" + enabled + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", enrollmentYear="
				+ enrollmentYear + ", enrollmentMonth=" + enrollmentMonth + ", active=" + active + ", validityEndYear="
				+ validityEndYear + ", validityEndMonth=" + validityEndMonth + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", programId=" + programId + ", email=" + email + ", mobile=" + mobile
				+ ", attempts=" + attempts + ", acadSession=" + acadSession + ", type=" + type + ", rollNo=" + rollNo
				+ ", campusId=" + campusId + ", campusName=" + campusName + ", deRegStatus=" + deRegStatus
				+ ", deRegReason=" + deRegReason + ", address=" + address + ", prgNameToShow=" + prgNameToShow
				+ ", role=" + role + "]";
	}
	
	
	

	
}
