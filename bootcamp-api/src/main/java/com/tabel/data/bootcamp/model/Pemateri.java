package com.tabel.data.bootcamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = "jadwalBootcamp")
@Table(name = "m_pemateri")
@EqualsAndHashCode(callSuper = false)
public class Pemateri extends User{

    @Column(name = "nama_pemateri")
    private String nama;

    @OneToMany(mappedBy = "pemateri")
    private List<Jadwal> jadwalBootcamp = new ArrayList<>();

}
