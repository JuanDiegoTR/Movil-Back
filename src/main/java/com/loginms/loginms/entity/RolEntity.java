package com.loginms.loginms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    @Column(name = "rol")
    private String rol;
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccesoEntity> acceso;

}
