package com.tabel.data.bootcamp.repository;

import com.tabel.data.bootcamp.model.Pemateri;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PemateriRepository extends PagingAndSortingRepository<Pemateri, String>{
    List<Pemateri> findAll();
    Pemateri findByNama(String nama);
}
