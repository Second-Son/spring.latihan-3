package com.tabel.data.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "s_roles")
public class Role {

    @Id
    @GenericGenerator(name = "gen_role", strategy = "uuid2")
    @GeneratedValue(generator = "gen_role")
    private String id;
    private String nama;
    @OneToMany(mappedBy = "role")
    private List<UserRoles> listRole = new ArrayList<>();
}
