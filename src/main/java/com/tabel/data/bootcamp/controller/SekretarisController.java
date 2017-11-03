package com.tabel.data.bootcamp.controller;

import com.tabel.data.bootcamp.model.*;
import com.tabel.data.bootcamp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class SekretarisController {

    @Autowired
    private PemateriRepository pemateriRepository;

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

    @Autowired
    private MateriRepository materiRepository;

    @GetMapping("/peserta/list")
    public String listPeserta(Authentication auth,Model model, Peserta peserta){
        model.addAttribute("p", pesertaRepository.findAll());
        return "/admin/listPeserta";
    }

    @GetMapping("/mentor/add")
    public String addPemateri(Authentication auth, Model model, @ModelAttribute Pemateri pemateri){
        model.addAttribute("addMentor", pemateri);
        return "/admin/addPemateri";
    }

    @PostMapping("/mentor/add")
    public String submitAddPemateri(Authentication auth, @ModelAttribute Pemateri pemateri, UserRoles userRoles){
        pemateri.setActive(true);
        pemateri.setPassword(passwordEncoder.encode(pemateri.getPassword()));
        userRoles.setUser(pemateri);
        Role role = roleRepository.findOne("1");
        userRoles.setRole(role);
        this.pemateriRepository.save(pemateri);
        this.userRolesRepository.save(userRoles);
        return "redirect:/admin/mentor/add";

    }

    @GetMapping("/jadwal/add")
    public String addJadwal(Authentication auth, Model model, Jadwal jadwal){
        model.addAttribute("j", pemateriRepository.findAll());
        model.addAttribute("lj", jadwalRepository.findAll());
        model.addAttribute("addWaktu", jadwal);
        return "/admin/addJadwal";
    }

    @PostMapping("/jadwal/add")
    public String submitAddJadwal(Authentication auth, @ModelAttribute Jadwal jadwal){
        this.jadwalRepository.save(jadwal);
        return "redirect:/admin/jadwal/add";
    }

    @GetMapping("/peserta/{id}")
    public String pesertaById(Authentication auth, @PathVariable(name = "id", required = true) Peserta peserta, Model model){
        model.addAttribute("p", peserta);
        return "/admin/dataPeserta";
    }

    @GetMapping("/jadwal/delete/{id}")
    public String deleteJadwal(@PathVariable(name = "id", required = true) Jadwal jadwal){
        materiRepository.deleteMateriJadwal(jadwal);
        jadwalRepository.delete(jadwal);
        return "redirect:/admin/jadwal/add";
    }

}
