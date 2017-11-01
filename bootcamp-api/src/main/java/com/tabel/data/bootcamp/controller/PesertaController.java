package com.tabel.data.bootcamp.controller;

import com.tabel.data.bootcamp.model.Peserta;
import com.tabel.data.bootcamp.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    private PesertaRepository pesertaRepository;

    @GetMapping("/registrasi")
    public String registrasiPeserta(Model model, Peserta peserta){
        model.addAttribute("model", peserta);
        return "/peserta/registrasi";
    }
}
