package com.tabel.data.bootcamp.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "m_sekretaris")
@EqualsAndHashCode(callSuper = false)
public class Sekretaris extends User{

    @Column(name = "nama_sekretaris")
    private String nama;
}
