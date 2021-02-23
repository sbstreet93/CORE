package com.base.template.member.ejemploServicio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

	@GetMapping(value = "/index")
	public String home(Model model) {
		return "index";
	}
	
}
