package com.tabel.data.bootcamp.controller;


import com.tabel.data.bootcamp.model.Jadwal;
import com.tabel.data.bootcamp.model.Materi;
import com.tabel.data.bootcamp.model.Pemateri;
import com.tabel.data.bootcamp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mentor")
public class PemateriController {

    @Autowired
    private PemateriRepository pemateriRepository;

    @Autowired
    private JadwalRepository jadwalRepository;

    @Autowired
    private SekretarisRepository sekretarisRepository;

    @Autowired
    private PesertaRepository pesertaRepository;

    @Autowired
    private MateriRepository materiRepository;

    @GetMapping("/materi/add")
    public String addJadwal(Authentication auth,Model model, Jadwal jadwal, Materi materi){
        model.addAttribute("m", jadwalRepository.findAll());
        model.addAttribute("p", materiRepository.findAll());
        model.addAttribute("addMateri", materi);
        return "/pemateri/addMateri";
    }

    @PostMapping("/materi/add")
    public  String submitAddJadwal(Authentication auth, @ModelAttribute Materi materi){
        this.materiRepository.save(materi);
        return "redirect:/mentor/materi/add";
    }

    @GetMapping("/materi/delete/{id}")
    public String deleteMateri (Authentication auth, @PathVariable(name = "id", required = true) Materi materi){

        materiRepository.delete(materi);
        return "redirect:/mentor/materi/add";
    }
}
