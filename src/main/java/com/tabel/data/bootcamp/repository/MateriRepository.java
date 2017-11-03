package com.tabel.data.bootcamp.repository;

import com.tabel.data.bootcamp.model.Jadwal;
import com.tabel.data.bootcamp.model.Materi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MateriRepository extends PagingAndSortingRepository<Materi, String> {
    List<Materi> findAll();
    List<Materi> findByJadwal(Jadwal jadwal);

    @Modifying
    @Transactional
    @Query("delete from Materi m where m.jadwal = ?1")
    void deleteMateriJadwal(Jadwal jadwal);
}
