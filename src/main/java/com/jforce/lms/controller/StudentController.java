package com.jforce.lms.controller;

import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.model.Course;
import com.jforce.lms.user.User;
import com.jforce.lms.user.UserDetailsImpl;
import com.jforce.lms.user.UserDetailsServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
	
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public StudentController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication){
        System.out.println("This is student profile page");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserRole userRole = userDetailsServiceImpl.findByUsername(userDetails.getUsername());
        System.out.println(userRole.toString());
        model.addAttribute("user",userRole);
        model.addAttribute("id",userRole.getUser().getUsername());
        model.addAttribute("firstname",userRole.getUser().getFirstname());
        model.addAttribute("lastname",userRole.getUser().getLastname());
        model.addAttribute("username",userRole.getUser().getUsername());
        model.addAttribute("role", userRole.getUser().getRole());
        return "profile";
    }
    
    @GetMapping("/student-faculty-details")
    public String details(Model model, Authentication authentication){
    	logger.info("This is Student-Faculty-Details");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserRole userRole = userDetailsServiceImpl.findByUsername(userDetails.getUsername());
        String programName = userDetailsServiceImpl.getUserProgramNameByUsername(userDetails.getUsername());
        String acadSession = userDetailsServiceImpl.getUserAcadSession(userDetails.getUsername());
        List<Course> courseDetails = userDetailsServiceImpl.getUserCourseDetails(userDetails.getUsername());
        List<User> facultyDetails = userDetailsServiceImpl.getStudentFacultyDetails(userDetails.getUsername());
        model.addAttribute("userRole",userRole);
        model.addAttribute("programName",programName);
        model.addAttribute("acadSession",acadSession);
        model.addAttribute("courseDetails",courseDetails);
        model.addAttribute("facultyDetails",facultyDetails);
        return "student-faculty-details";
    }
}
