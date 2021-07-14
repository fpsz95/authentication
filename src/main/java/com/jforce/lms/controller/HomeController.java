package com.jforce.lms.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.user.User;
import com.jforce.lms.user.UserDetailsServiceImpl;


@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	public HomeController(UserDetailsServiceImpl userDetailsServiceImpl) {
		super();
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	
	@GetMapping("/sap_registration")
	public String sapRegistration()
	{
		return "sap_registration";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signupuser(@ModelAttribute User user,HttpServletResponse response) throws IOException
	{
		System.out.println(user.getUsername());
		userDetailsServiceImpl.addUser(user);
		response.sendRedirect("signin");//two lines... :(
		return "signin";
	}

    @GetMapping("/signin")
    public String signin(HttpServletRequest request, Model model){
        logger.info("INSIDE GET /signin");
        String msg = request.getParameter("msg");
        logger.info("msg is "+ msg);
		if("error".equals(msg))
		{
			model.addAttribute("error","Invalid Credentials");
			return "signin";
		}
		else {
			return "signin";
		}
    }
    
    
//    @PostMapping("/signin?msg=error")
//    public String signinerror(@PathVariable("msg") String msg, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException{
//        logger.info("INSIDE POST /signin?msg=error");
//    		if(msg=="error"){
//    			model.addAttribute("error", "Invalid Credentials post");
//			}
//        return "signin";
//    }
    
    @GetMapping("/changePassword")
    public String changePassword() {
    	return "change-password";
    }
    
    @PostMapping("/changeUserPassword")
    public String changeUserPassword(ModelMap model, String username, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	logger.info("INSIDE /changeUserPassword");
    		UserRole userRole = userDetailsServiceImpl.findByUsername(username);
    		logger.info("userRole is " + userRole);
    		if(userRole==null) {
    			return null;
    		}else {
    			logger.info("Username Found");
    			model.addAttribute("username", username);
    			return "create-new-password";
    		}
    }
    
    @PostMapping("/changingUserPassword")
    public String changingUserPassword(String username, String newPassword) {
    	logger.info("INSIDE changingUserPassword");
    	logger.info("username is" + username);
    	logger.info("New Password Received from Frontend is " + newPassword);
    	userDetailsServiceImpl.changeUserPassword(username, newPassword);
    	return "signin";
    }
    
	
//	User user = userDetailsServiceImpl.getUserDetails(username);
//	if(user==null) {
//		return "username not found";
//	}else {
}
