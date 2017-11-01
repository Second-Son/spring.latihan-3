package com.tabel.data.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_user_roles")
public class UserRoles {

    @Id
    @GenericGenerator(name = "gen_userrole", strategy = "uuid2")
    @GeneratedValue(generator = "gen_userrole")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;
}
