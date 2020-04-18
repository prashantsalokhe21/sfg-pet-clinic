package com.springframework.sfgpetclinic.controller;

import com.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        super();
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }


}
