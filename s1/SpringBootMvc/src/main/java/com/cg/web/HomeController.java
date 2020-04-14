package com.cg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//@GetMapping("/home")
	@RequestMapping(value= {"/","/home"})
	public String displayHomePg() {
		return "HomePage";
	}
	
}
