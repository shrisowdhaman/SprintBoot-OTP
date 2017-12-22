package com.shri.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shri.repo.BookRepository;
import com.shri.service.OtpService;


@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    BookRepository repo;
    
    @Autowired
	public OtpService otpService;

    @GetMapping("/")
    public String homePage(Model model) {
    	
    	String message = " Welcome to my Page";
    	
        model.addAttribute("appName", appName);
        model.addAttribute("message", message);
       
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        logger.info("username: " + auth.getName()); 
        
        return "signin";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        logger.info("username: " + auth.getName()); 

    	return "dashboard";
    }
    
    @GetMapping("/login")
    public String login() {
        return "signin";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/aboutus")
    public String about() {
        return "aboutus";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response){
    	
       Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
       if (auth != null){    
    	   String username = auth.getName();
    	   
    	   //Remove the recently used OTP from server. 
    	   otpService.clearOTP(username);
           
    	   new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       
	   return "redirect:/login?logout";    	
    }
    
}
