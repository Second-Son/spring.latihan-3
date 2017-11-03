package com.tabel.data.bootcamp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String indexHtml(Authentication auth, Model model){
        model.addAttribute("titleApp",
                "Aplikasi Pendaftaran Bootcamp");
        return "/index";
    }

    @GetMapping("/login-form")
    public String showFormLogin(){
        return "/login";
    }
}
