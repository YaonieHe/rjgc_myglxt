package com.rjgc.rjgcweb.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by hyxiao on 2018/03/26.
 */
@Controller
@RequestMapping("/main")
public class MainController {

  @GetMapping("")
  public String main(Model model) {
	String mainpage = "common/default";
	model.addAttribute("mainpage", mainpage);
	System.out.println("main");
    return "common/main";
  }

  @PostMapping("")
  public String post() {
    return "common/main";
  }
}