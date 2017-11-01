package com.tabel.data.bootcamp.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_peserta")
@EqualsAndHashCode(callSuper = false)
public class Peserta extends User{

    @NotNull
    @NotEmpty
    @Column(name = "nama_peserta")
    private String nama;

    @NotNull
    @NotEmpty
    @Column(name = "alamat_peserta")
    private String alamat;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @Column(name = "sekolah")
    private String sekolah;

    @Column(name = "tahun_lulus")
    private String tahunLulus;

    @Column(name = "ipk")
    private String ipk;
}
