package com.jforce.lms.controller;

import com.jforce.lms.mappings.UserRole;
import com.jforce.lms.user.User;
import com.jforce.lms.user.UserDetailsImpl;
import com.jforce.lms.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public AdminController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication){
        System.out.println("This is admin profile page");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserRole userRole = userDetailsServiceImpl.findByUsername(userDetails.getUsername());
        System.out.println(userRole.toString());
        model.addAttribute("userRole",userRole);
        model.addAttribute("id",userRole.getUser().getUsername());
        model.addAttribute("firstname",userRole.getUser().getFirstname());
        model.addAttribute("lastname",userRole.getUser().getLastname());
        model.addAttribute("username",userRole.getUser().getUsername());
        model.addAttribute("role", userRole.getRole().getRole());
        return "profile";
    }
}
