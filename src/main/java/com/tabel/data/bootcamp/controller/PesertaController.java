package com.tabel.data.bootcamp.controller;

import com.tabel.data.bootcamp.model.Jadwal;
import com.tabel.data.bootcamp.model.Materi;
import com.tabel.data.bootcamp.model.Peserta;
import com.tabel.data.bootcamp.repository.JadwalRepository;
import com.tabel.data.bootcamp.repository.MateriRepository;
import com.tabel.data.bootcamp.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    private PesertaRepository pesertaRepository;

    @Autowired
    private JadwalRepository jadwalRepository;

    @Autowired
    private MateriRepository materiRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registrasi")
    public String registrasiPeserta(Authentication auth, Model model, Peserta peserta, Jadwal jadwal){
        model.addAttribute("jw", jadwalRepository.findAll());
        model.addAttribute("registrasi", peserta);
        return "/peserta/registrasi";
    }

    @PostMapping({"/registrasi"})
    public String submitPeserta(Authentication auth, @ModelAttribute Peserta peserta) {
        peserta.setActive(true);
        peserta.setPassword(passwordEncoder.encode(peserta.getPassword()));
        this.pesertaRepository.save(peserta);
        return "redirect:/peserta/registrasi";
    }

    @GetMapping("/jadwal/{idJadwal}")
    public String listJadwal(Authentication auth, @PathVariable(name = "idJadwal", required = true) Jadwal jadwal, Model model, Materi materi){
        model.addAttribute("jw", jadwalRepository.findAll());
        model.addAttribute("jm", materiRepository.findByJadwal(jadwal));
        return "/peserta/listJadwal";
    }
}
