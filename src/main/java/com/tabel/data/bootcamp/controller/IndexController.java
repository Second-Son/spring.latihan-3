package com.tabel.data.bootcamp.controller;

import com.tabel.data.bootcamp.model.Jadwal;
import com.tabel.data.bootcamp.model.Peserta;
import com.tabel.data.bootcamp.model.Role;
import com.tabel.data.bootcamp.model.UserRoles;
import com.tabel.data.bootcamp.repository.JadwalRepository;
import com.tabel.data.bootcamp.repository.PesertaRepository;
import com.tabel.data.bootcamp.repository.RoleRepository;
import com.tabel.data.bootcamp.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private JadwalRepository jadwalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PesertaRepository pesertaRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

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


    @GetMapping("/registrasi")
    public String registrasiPeserta(Model model, Peserta peserta, Jadwal jadwal){
        model.addAttribute("jw", jadwalRepository.findAll());
        model.addAttribute("registrasi", peserta);
        return "/registrasi";
    }

    @PostMapping({"/registrasi"})
    public String submitPeserta(@ModelAttribute Peserta peserta, UserRoles userRoles) {
        peserta.setActive(true);
        peserta.setPassword(passwordEncoder.encode(peserta.getPassword()));
        userRoles.setUser(peserta);
        Role role = roleRepository.findOne("1");
        userRoles.setRole(role);
        this.pesertaRepository.save(peserta);
        this.userRolesRepository.save(userRoles);
        return "redirect:/login-form";
    }
}
