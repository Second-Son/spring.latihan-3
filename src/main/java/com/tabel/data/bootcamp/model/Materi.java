package com.tabel.data.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author secondson
 */

@Data
@Entity
@Table(name = "m_materi")
@AllArgsConstructor
@NoArgsConstructor

public class Materi {
    @Id
    @GenericGenerator(name = "gen_jadwal", strategy = "uuid2")
    @GeneratedValue(generator = "gen_jadwal")
    private String id;

    @Column(name = "materi")
    private String materi;

    @ManyToOne
    @JoinColumn(name = "id_jadwal", nullable = false)
    private Jadwal jadwal;    
}
