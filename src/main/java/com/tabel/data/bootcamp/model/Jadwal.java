package com.tabel.data.bootcamp.model;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import lombok.ToString;

@Data
@Entity
@Table(name = "m_jadwal")
@ToString(exclude = "materiBootcamp")
@AllArgsConstructor
@NoArgsConstructor
public class Jadwal {

    @Id
    @GenericGenerator(name = "gen_jadwal", strategy = "uuid2")
    @GeneratedValue(generator = "gen_jadwal")
    private String id;

    @Column(name = "waktu")
    private String waktu;

    @ManyToOne
    @JoinColumn(name = "id_pemateri", nullable = false)
    private Pemateri pemateri;

    @OneToMany(mappedBy = "jadwal")
    private List<Materi> materiBootcamp = new ArrayList<>();
}
