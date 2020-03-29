package com.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.sfgpetclinic.services.OwnerService;

@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@RequestMapping({"/owners","/owners/index","owners/index.html"})
	public String ownerList(Model model) {
		
		model.addAttribute("owners", ownerService.findAll());
		return "/owners/index";
	}

}
