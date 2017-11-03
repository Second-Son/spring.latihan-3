package com.tabel.data.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_sekretaris")
@EqualsAndHashCode(callSuper = false)
public class Sekretaris extends User{

    @Column(name = "nama_sekretaris")
    private String nama;
}
