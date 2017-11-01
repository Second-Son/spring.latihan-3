package com.tabel.data.bootcamp.repository;

import com.tabel.data.bootcamp.model.Peserta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PesertaRepository extends PagingAndSortingRepository<Peserta, String>{
    List<Peserta> findAll();

    Peserta findByUsername(String username);
}
