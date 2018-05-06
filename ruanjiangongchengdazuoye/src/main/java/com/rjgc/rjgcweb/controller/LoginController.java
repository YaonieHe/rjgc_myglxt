package com.rjgc.rjgcweb.controller;
import com.rjgc.rjgcweb.entity.Manager;
import com.rjgc.rjgcweb.service.ManagerService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.Data;
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ManagerService managerService;
	
	public boolean isLogin(String username, String password) {
		System.out.println("controller");
	    if (managerService.login(username, password)) {
	      return true;
	    } else {
	      return false;
	    }
	}
	
    @GetMapping("")
    public String loginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        System.out.println("login");
        return "login/login";
    }
    @PostMapping("")
    public String loginSubmit(@ModelAttribute LoginForm loginForm, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
    	HttpSession session = request.getSession();
    	String sRand=(String) session.getAttribute("sRand");
    	String username = loginForm.username;
    	String password = loginForm.password;
    	String captcha = loginForm.verifyCode;
    	boolean rememberme = loginForm.rememberme;
    	loginForm.password="";
    	loginForm.verifyCode="";
    	loginForm.error="";
    	if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
    		loginForm.error="..........";
			return "login/login";
		}
	 	if(StringUtil.isEmpty(captcha)){
	 		loginForm.error=".....";
	 		return "login/login";
		}else if(!captcha.equals(sRand)){
	 		loginForm.error="............";
	 		return "login/login";
		}
		if(isLogin(username, password)){
			/*
			 *.remember me
			 */
			/*
			 * 
.			 */
			session.setAttribute("username", username);
			return "redirect:/main";
		}
		else{
			loginForm.error="........";
			/*
			 * 
			 */
			request.setAttribute("user1", "cc");
			return "login/login";
		}
    	
    }
    public static class StringUtil {
    	public static boolean isEmpty(String str){
    		if("".equals(str)||str==null){
    			return true;
    		}else{
    			return false;
    		}
    	}    	
    	public static boolean equal(String str, String pattern){
    		if(pattern.equals(str)||str==null||pattern==null){
    			return true;
    		}else{
    			return false;
    		}
    	}
    	public static boolean isNotEmpty(String str){
    		if(!"".equals(str)&&str!=null){
    			return true;
    		}else{
    			return false;
    		}
    	}
    }
    @Data
    public static class LoginForm {
         private String username;
         private String password;
         private String verifyCode;
         private String error;
         private boolean rememberme; 
    }
}
