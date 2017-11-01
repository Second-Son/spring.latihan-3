package com.tabel.data.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "m_jadwal")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Jadwal {

    @Id
    @GenericGenerator(name = "gen_jadwal", strategy = "uuid2")
    @GeneratedValue(generator = "gen_jadwal")
    private String id;

    @Column(name = "waktu")
    private String waktu;

    @Column(name = "materi")
    private String Materi;

    @ManyToOne
    @JoinColumn(name = "id_pemateri", nullable = false)
    private Pemateri pemateri;
}
