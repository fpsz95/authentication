package com.jforce.lms.user;

import com.jforce.lms.dao.UserDAO;
import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.model.Course;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private HttpServletRequest request;
//    
//    @Autowired
//    private HttpServletResponse response;

    @Autowired
    public UserDetailsServiceImpl(
            UserDAO userDAO,
            PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("loadUserByUsername(String username)");
//        UserRole userRole = userDAO.findByUsername(username);
//        System.out.println("after finding user");
//        System.out.println("UserRole is " + userRole);
//        if(userRole == null) {
//        	System.out.println("inside user == null");
//        	throw new UsernameNotFoundException("user with username" + username + "is not found");
//        }
//        return new UserDetailsImpl(userRole);
//    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername(String username)");
//        User user = userDAO.findByUsername(username);
        Optional<User> user = userDAO.findByUsernameTest(username);
        log.info("after finding user");
        log.info("UserRole is " + user);
        user.orElseThrow(() -> 
        	new UsernameNotFoundException(String.format("username %s not found",username)));
        return user.map(UserDetailsImpl::new).get();
    }

	public void addUser(User user) {
        userDAO.insertUser(user);
	}


    public UserRole findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

	public String getUserProgramNameByUsername(String username) {
		return userDAO.getProgramNameByUsername(username);
	}

	public String getUserAcadSession(String username) {
		return userDAO.getUserAcadSession(username);
	}

	public List<Course> getUserCourseDetails(String username) {
		return userDAO.getUserCourseDetails(username);
	}

	public List<User> getStudentFacultyDetails(String username) {
		return userDAO.getStudentFacultyDetails(username);
	}

	public List<User> getFacultyStudentsDetails(String username) {
		return userDAO.getFacultyStudentsDetails(username);
	}

	public int changeUserPassword(String username, String newPassword) {
		String newEncodedPassword = passwordEncoder.encode(newPassword);
		return userDAO.changeUserPassword(username, newEncodedPassword);
	}

	public User getUserDetails(String username) {
		return userDAO.getUserDetails(username);
	};
    
	
//    @Bean 
//    public RequestContextFilter requestContextListener(){
//        return new RequestContextFilter();
//    }
}
