package com.jforce.lms.model;

public class Course {
	private String id;
	private String abbr;
	private String courseName;
	private String active;
	private String createdBy;
	private String createdDate;
	private String lastModifiedBy;
	private String lastModifiedDate;
	private String property1;
	private String property2;
	private String property3;
	private String programId;
	private String acadYear;
	private String acadMonth;
	private String acadYearCode;
	private String eventName;
	private String acadSession;
	private String moduleId;
	private String moduleName;
	private String campusId;
	private String moduleAbbr;
	private String deptCode;
	private String dept;
	private String moduleCategoryCode;
	private String moduleCategoryName;
	
	public Course() {
		super();
	}
	
	public Course(String id, String abbr, String courseName, String active, String createdBy, String createdDate,
			String lastModifiedBy, String lastModifiedDate, String property1, String property2, String property3,
			String programId, String acadYear, String acadMonth, String acadYearCode, String eventName,
			String acadSession, String moduleId, String moduleName, String campusId, String moduleAbbr, String deptCode,
			String dept, String moduleCategoryCode, String moduleCategoryName) {
		super();
		this.id = id;
		this.abbr = abbr;
		this.courseName = courseName;
		this.active = active;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
		this.programId = programId;
		this.acadYear = acadYear;
		this.acadMonth = acadMonth;
		this.acadYearCode = acadYearCode;
		this.eventName = eventName;
		this.acadSession = acadSession;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.campusId = campusId;
		this.moduleAbbr = moduleAbbr;
		this.deptCode = deptCode;
		this.dept = dept;
		this.moduleCategoryCode = moduleCategoryCode;
		this.moduleCategoryName = moduleCategoryName;
	}
	
	public Course(String courseName, String moduleAbbr) {
		super();
		this.courseName = courseName;
		this.moduleAbbr = moduleAbbr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public String getProperty3() {
		return property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getAcadYear() {
		return acadYear;
	}

	public void setAcadYear(String acadYear) {
		this.acadYear = acadYear;
	}

	public String getAcadMonth() {
		return acadMonth;
	}

	public void setAcadMonth(String acadMonth) {
		this.acadMonth = acadMonth;
	}

	public String getAcadYearCode() {
		return acadYearCode;
	}

	public void setAcadYearCode(String acadYearCode) {
		this.acadYearCode = acadYearCode;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getAcadSession() {
		return acadSession;
	}

	public void setAcadSession(String acadSession) {
		this.acadSession = acadSession;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getCampusId() {
		return campusId;
	}

	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}

	public String getModuleAbbr() {
		return moduleAbbr;
	}

	public void setModuleAbbr(String moduleAbbr) {
		this.moduleAbbr = moduleAbbr;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getModuleCategoryCode() {
		return moduleCategoryCode;
	}

	public void setModuleCategoryCode(String moduleCategoryCode) {
		this.moduleCategoryCode = moduleCategoryCode;
	}

	public String getModuleCategoryName() {
		return moduleCategoryName;
	}

	public void setModuleCategoryName(String moduleCategoryName) {
		this.moduleCategoryName = moduleCategoryName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", abbr=" + abbr + ", courseName=" + courseName + ", active=" + active
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedDate=" + lastModifiedDate + ", property1=" + property1 + ", property2=" + property2
				+ ", property3=" + property3 + ", programId=" + programId + ", acadYear=" + acadYear + ", acadMonth="
				+ acadMonth + ", acadYearCode=" + acadYearCode + ", eventName=" + eventName + ", acadSession="
				+ acadSession + ", moduleId=" + moduleId + ", moduleName=" + moduleName + ", campusId=" + campusId
				+ ", moduleAbbr=" + moduleAbbr + ", deptCode=" + deptCode + ", dept=" + dept + ", moduleCategoryCode="
				+ moduleCategoryCode + ", moduleCategoryName=" + moduleCategoryName + "]";
	}
	
	
	
}
