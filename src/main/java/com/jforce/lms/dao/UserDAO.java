package com.jforce.lms.dao;

import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.model.Course;
import com.jforce.lms.model.Role;
import com.jforce.lms.user.User;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Autowired
	private PasswordEncoder passwordEncoder;

    public UserDAO()
    {

    }

    public int createTable(){
        String query = "CREATE TABLE IF NOT EXISTS User(" +
                "id int primary key," +
                "first_name varchar(25), " +
                "last_name varchar(25), " +
                "username varchar(25), " +
                "password varchar(100)," +
                "role varchar(25))";
        int update = this.jdbcTemplate.update(query);
        return update;
    }

	Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());


    public int insertUser(User user){
    	
    	String query = "INSERT INTO USERS("
        		+ "username,"
        		+ "firstname,"
        		+ "lastname,"
        		+ "password,"
        		+ "enabled,"
        		+ "createdDate,"
        		+ "createdBy,"
        		+ "lastModifiedDate,"
        		+ "lastModifiedBy,"
        		+ "enrollmentYear,"
        		+ "enrollmentMonth,"
        		+ "active,"
        		+ "validityEndYear,"
        		+ "validityEndMonth,"
        		+ "fatherName,"
        		+ "motherName,"
        		+ "programId,"
        		+ "email,"
        		+ "mobile,"
        		+ "attempts,"
        		+ "acadSession,"
        		+ "type,"
        		+ "rollNo,"
        		+ "campusId,"
        		+ "campusName,"
        		+ "deRegStatus,"
        		+ "deRegReason,"
        		+ "address,"
        		+ "prgNameToShow"
        		+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE firstname=?";

//        String query = "INSERT INTO USERS("
//        		+ "username,"
//        		+ "firstname,"
//        		+ "lastname,"
//        		+ "password,"
//        		+ "enabled,"
//        		+ "createdDate,"
//        		+ "createdBy,"
//        		+ "lastModifiedDate,"
//        		+ "lastModifiedBy,"
//        		+ "enrollmentYear,"
//        		+ "enrollmentMonth,"
//        		+ "active,"
//        		+ "validityEndYear,"
//        		+ "validityEndMonth,"
//        		+ "fatherName,"
//        		+ "motherName,"
//        		+ "programId,"
//        		+ "email,"
//        		+ "mobile,"
//        		+ "attempts,"
//        		+ "acadSession,"
//        		+ "type,"
//        		+ "rollNo,"
//        		+ "campusId,"
//        		+ "campusName,"
//        		+ "deRegStatus,"
//        		+ "deRegReason,"
//        		+ "address,"
//        		+ "prgNameToShow"
//        		+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int update = this.jdbcTemplate.update(query, new Object[]{
        		user.getUsername(),
        		user.getFirstname(),
        		user.getLastname(),
        		passwordEncoder.encode(user.getPassword()),
        		1,
        		timestamp,
				"Peter",
				timestamp,
				"Peter",
				"2020",
        		user.getEnrollmentMonth(),
				"Y",
				"2020",
				"Dec",
        		user.getFatherName(),
        		user.getMotherName(),
        		user.getProgramId(),
        		user.getEmail(),
        		user.getMobile(),
				"0",
        		user.getAcadSession(),
        		null,
        		user.getRollNo(),
				51405435,
				"Centre of Interior Enviornment  Design",
        		null,
        		null,
				"abcd",
				null,
				user.getFirstname()
        		});
        return update;
    }

    RowMapper<User> rowMapper = (rs,rowNum) -> {
    	User user = new User();
    	user.setUsername(rs.getString("username"));
    	user.setPassword(rs.getString("password"));
    	user.setRole(rs.getString("role"));
    	logger.info("RowMapper User Object is " + user);
    	return user;
    };
    
    public Optional<User> findByUsernameTest(String username) {
      logger.info("INSIDE findByUsernameTest(String username)");
      //WORKING EXCEPT USERNAME,USERNAME_P SCENARIOS
//      String query = "SELECT users.username,users.firstname,users.lastname,users.email,users.password,user_roles.role -- users.*,user_roles.role\r\n"
//      		+ "FROM users \r\n"
//      		+ "LEFT JOIN user_roles\r\n"
//      		+ "ON users.username=user_roles.username\r\n"
//      		+ "WHERE users.username=?";
    String query = "SELECT users.username,users.firstname,users.lastname,users.email,users.password,user_roles.role -- users.*,user_roles.role\r\n"
    		+ "FROM users \r\n"
    		+ "LEFT JOIN user_roles\r\n"
    		+ "ON users.username=user_roles.username\r\n"
    		+ "WHERE users.username=? AND user_roles.role IN (\"ROLE_STUDENT\",\"ROLE_FACULTY\",\"ROLE_ADMIN\");";
    User user = null;
      try {
      user =  jdbcTemplate.queryForObject(query,rowMapper,new Object[]{username});
      }
      catch(RuntimeException re) {
    	  re.printStackTrace();
    	  logger.info("findByUsernameTest - Username not Found");
      }
      return Optional.ofNullable(user);      
  }
    
    public UserRole findByUsername(String username) {
        logger.info("INSIDE findByUsername(String username)");
        //WORKING EXCEPT USERNAME,USERNAME_P SCENARIOS
//        String query = "SELECT users.username,users.firstname,users.lastname,users.email,users.password,user_roles.role -- users.*,user_roles.role\r\n"
//        		+ "FROM users \r\n"
//        		+ "LEFT JOIN user_roles\r\n"
//        		+ "ON users.username=user_roles.username\r\n"
//        		+ "WHERE users.username=?";
      String query = "SELECT users.username,users.firstname,users.lastname,users.email,users.password,user_roles.role -- users.*,user_roles.role\r\n"
      		+ "FROM users \r\n"
      		+ "LEFT JOIN user_roles\r\n"
      		+ "ON users.username=user_roles.username\r\n"
      		+ "WHERE users.username=? AND user_roles.role IN (\"ROLE_STUDENT\",\"ROLE_FACULTY\",\"ROLE_ADMIN\");";
        try {
        return jdbcTemplate.queryForObject(query,(rs,rowNum) ->{
                        User user = new User();
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        Role role = new Role();
                        role.setRole(rs.getString("role"));
                        return new UserRole(user,role);
                        		},
                new Object[]{username}
        );
        }
        catch(RuntimeException re) {
      	  System.out.println("findByUsername - Username not Found");
    		return null;
        }
    }
    
    public User getUserDetails(String username){
    	System.out.println("Inside UserDAO getUserDetails - username is = " + username);
    	String query = "SELECT *,user_roles.role\r\n"
    			+ "FROM users \r\n"
    			+ "LEFT JOIN user_roles\r\n"
    			+ "ON users.username=user_roles.username\r\n"
    			+ "WHERE users.username=?";
    	
    	try {
    		return jdbcTemplate.queryForObject(query,(rs,rowNum) ->
            new User(
                    rs.getString("username"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("password"),
                    rs.getString("enabled"),
                    rs.getString("createdDate"),
                    rs.getString("createdBy"),
                    rs.getString("lastModifiedDate"),
                    rs.getString("lastModifiedBy"),
                    rs.getString("enrollmentYear"),
                    rs.getString("enrollmentMonth"),
                    rs.getString("active"),
                    rs.getString("validityEndYear"),
                    rs.getString("validityEndMonth"),
                    rs.getString("fatherName"),
                    rs.getString("motherName"),
                    rs.getInt("programId"),//
                    rs.getString("email"),
                    rs.getDouble("mobile"),
                    rs.getString("attempts"),
                    rs.getString("acadSession"),
                    rs.getString("type"),
                    rs.getString("rollNo"),
                    rs.getString("campusId"),
                    rs.getString("campusName"),
                    rs.getString("deRegStatus"),
                    rs.getString("deRegReason"),
                    rs.getString("address"),
                    rs.getString("prgNameToShow"),
                    rs.getString("role")
            		),
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		System.out.println("userdao exception user not found");
    		return null;
    	}
}

    public User getUserDetailsTest(String username){
    	System.out.println("Inside UserDAO getUserDetails - username is = " + username);
    	String query = "SELECT *,user_roles.role\r\n"
    			+ "FROM users \r\n"
    			+ "LEFT JOIN user_roles\r\n"
    			+ "ON users.username=user_roles.username\r\n"
    			+ "WHERE users.username=?";
    	
    	try {
    		return jdbcTemplate.queryForObject(query,(rs,rowNum) -> {
    			User user = new User();
    			user.setUsername(rs.getString("username"));
    			user.setMobile(rs.getDouble("mobile"));
    			return user;
    		},
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		System.out.println("userdao exception user not found");
    		return null;
    	}
}
    
    public String getProgramNameByUsername(String username) {
    	String query = "SELECT programName\r\n"
    			+ "FROM program\r\n"
    			+ "WHERE id IN\r\n"
    			+ "	(SELECT programId \r\n"
    			+ "	FROM course\r\n"
    			+ "	WHERE id IN \r\n"
    			+ "		(SELECT courseId\r\n"
    			+ "		FROM user_course\r\n"
    			+ "		WHERE username=?))";
    	
    	try {
    		return jdbcTemplate.queryForObject(query,(rs,rowNum) ->
    			rs.getString("programName"),
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		re.printStackTrace();
    		System.out.println("User not found with ProgramName");
    		return "User Program Name not Found";
    	} 
    }

	public String getUserAcadSession(String username) {
//	   	String query = "SELECT acadSession\r\n"
//	   			+ "FROM user_course\r\n"
//	   			+ "WHERE username=?";
	   	String query = "SELECT distinct acadSession\r\n"
	   			+ "FROM user_course\r\n"
	   			+ "WHERE username=? AND acadYear=? AND acadMonth=?;";
    	try {
    		return jdbcTemplate.queryForObject(query,(rs,rowNum) ->
    			rs.getString("acadSession"),
            new Object[]{username,2020,"Nov"}
            );
    	}catch(RuntimeException re) {
    		re.printStackTrace();
    		System.out.println("User AcadSession Not Found");
    		return "User AcadSession Not Found";
    	} 
	}

	public List<Course> getUserCourseDetails(String username) {
		logger.info("INSIDE public List<Course> getUserCourseDetails(String username)");
		String query = "SELECT courseName,moduleAbbr\r\n"
				+ "FROM course\r\n"
				+ "WHERE id IN\r\n"
				+ "		(SELECT courseId\r\n"
				+ "		FROM user_course\r\n"
				+ "		WHERE username=? AND acadYear='2020' AND acadMonth='July' --  AND acadSession='Semester I'\r\n"
				+ "        );";
    	try {
    		return jdbcTemplate.query(query,(rs,rowNum) ->
    		new Course(
    			rs.getString("courseName"),
    			rs.getString("moduleAbbr")
    			),
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		re.printStackTrace();
    		System.out.println("User Course Details Not Found");
    		return null;
    	} 
	}

	public List<User> getStudentFacultyDetails(String username) {
		String query = "SELECT *\r\n"
				+ "FROM users\r\n"
				+ "WHERE username IN\r\n"
				+ "	(SELECT username \r\n"
				+ "	FROM user_course\r\n"
				+ "	WHERE role='ROLE_FACULTY' AND courseId IN\r\n"
				+ "		(SELECT  courseId\r\n"
				+ "		FROM user_course\r\n"
				+ "		WHERE username=?))";
    	try {
    		return jdbcTemplate.query(query,(rs,rowNum) ->
    		new User(
    			rs.getString("username"),
    			rs.getString("firstname"),
    			rs.getString("lastname"),
    			rs.getString("email")
    			),
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		re.printStackTrace();
    		System.out.println("Student Faculty Details Not Found");
    		return null;
    	} 
	}

	public List<User> getFacultyStudentsDetails(String username) {
		String query = "SELECT username,firstname,lastname,rollNo \r\n"
				+ "FROM users\r\n"
				+ "WHERE username IN\r\n"
				+ "	(SELECT username \r\n"
				+ "	FROM user_course\r\n"
				+ "	WHERE role=\"ROLE_STUDENT\" AND courseId IN\r\n"
				+ "		(SELECT courseId\r\n"
				+ "		FROM user_course\r\n"
				+ "		WHERE username=? -- AND acadYear='2020' AND acadMonth='July' AND acadSession='Semester I'\r\n"
				+ "        ))";
    	try {
    		return jdbcTemplate.query(query,(rs,rowNum) ->
    		new User(
    			rs.getString("username"),
    			rs.getString("firstname"),
    			rs.getString("lastname"),
    			rs.getString("rollNo")
    			),
            new Object[]{username}
            );
    	}catch(RuntimeException re) {
    		re.printStackTrace();
    		System.out.println("Student Faculty Details Not Found");
    		return null;
    	} 
	}

	public int changeUserPassword(String username, String newPassword) {
		 logger.info("changeUserPassword(String newPassword)");
	      String query = "UPDATE users\r\n"
	      		+ "SET password = ?\r\n"
	      		+ "WHERE username = ?;";
	      int noOfRowsAffected = this.jdbcTemplate.update(query,newPassword,username);
	      System.out.println("noOfRowsAffected" + noOfRowsAffected);
	        return noOfRowsAffected;
	}
}
