package com.jforce.lms.controller;

import com.jforce.lms.jwt.JwtTokenVerifier;
import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.model.Course;
import com.jforce.lms.user.User;
import com.jforce.lms.user.UserDetailsImpl;
import com.jforce.lms.user.UserDetailsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("faculty")
public class FacultyController {
	
    Logger logger = LoggerFactory.getLogger(FacultyController.class);

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public FacultyController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication){
        System.out.println("This is faculty profile page");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetailsServiceImpl.getUserDetails(userDetails.getUsername());
        System.out.println(user.toString());
        logger.info("User user = userDetailsServiceImpl.getUserDetails(userDetails.getUsername())");
        model.addAttribute("user",user);
        return "profile";
    }

    @GetMapping("/page2")
    public String page2(){
        System.out.println("This is page 2");
        return "page2";
    }

    @GetMapping("/logout")
    public String page2(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        System.out.println("Logged out");
        System.out.println(request.getSession().getAttribute("Authorization"));
        System.out.println(request.getSession().getId());
        return "signin";
    }
    
    @GetMapping("/faculty-students-details")
    public String facultyStudentsDetails(Model model, Authentication authentication){
    	logger.info("INSIDE /faculty-students-details");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserRole userRole = userDetailsServiceImpl.findByUsername(userDetails.getUsername());
        String programName = userDetailsServiceImpl.getUserProgramNameByUsername(userDetails.getUsername());
        String acadSession = userDetailsServiceImpl.getUserAcadSession(userDetails.getUsername());
        List<Course> courseDetails = userDetailsServiceImpl.getUserCourseDetails(userDetails.getUsername());
        List<User> studentsDetails = userDetailsServiceImpl.getFacultyStudentsDetails(userDetails.getUsername());
        model.addAttribute("user",userRole);
        model.addAttribute("studentsDetails",studentsDetails);
        model.addAttribute("programName",programName);
        model.addAttribute("acadSession",acadSession);
        model.addAttribute("courseDetails",courseDetails);
        return "faculty-students-details";
    }
}
