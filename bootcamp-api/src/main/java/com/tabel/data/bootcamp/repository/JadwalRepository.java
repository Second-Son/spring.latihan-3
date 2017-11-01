package com.tabel.data.bootcamp.repository;

import com.tabel.data.bootcamp.model.Jadwal;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JadwalRepository extends PagingAndSortingRepository<Jadwal, String>{
    List<Jadwal> findAll();
}
