package com.rjgc.rjgcweb.controller;

import lombok.Data;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjgc.rjgcweb.entity.Manager;
import com.rjgc.rjgcweb.repository.ManagerRepository;

import com.rjgc.rjgcweb.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * Created by hejiangping on 2018-5-5
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
  @Autowired
  private ManagerService managerService;
  @GetMapping("")
  public String helloForm(Model model) {
    model.addAttribute("helloMsg", new HelloMsg());
	String mainpage = "mainpage/hello";
	model.addAttribute("mainpage", mainpage);
	System.out.println("main");
    return "common/main";
  }

  @PostMapping("")
  public String helloSubmit(Model model,@ModelAttribute HelloMsg helloMsg) {
    System.out.println(helloMsg.msg + " " + helloMsg.name);
    boolean rel = true;
    model.addAttribute("helloMsg", helloMsg);
	String mainpage = "mainpage/result";
	model.addAttribute("mainpage", mainpage);
	System.out.println("main");
    return "common/main";
  }

  @Data
  public static class HelloMsg {
    private String msg;
    private String name;
    HelloMsg(String s1,String s2){
    	name=s1;
    	msg=s2;
    }
    HelloMsg(){}
  }
  
}

