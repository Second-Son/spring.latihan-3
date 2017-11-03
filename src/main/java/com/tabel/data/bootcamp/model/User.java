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
@Table(name = "s_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GenericGenerator(name = "gen_user", strategy = "uuid2")
    @GeneratedValue(generator = "gen_user")
    private String id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String username;

    @Column(name = "passwd", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<UserRoles> roles = new ArrayList<>();
}
