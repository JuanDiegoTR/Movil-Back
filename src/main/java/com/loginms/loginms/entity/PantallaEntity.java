package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "pantalla")
public class PantallaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pantalla;
    @Column(name = "pantalla")
    private String pantalla;

    /*@OneToMany(mappedBy = "pantalla", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccesoEntity> acceso;*/
    @ManyToMany(mappedBy = "pantallas")
    private Set<RolEntity> rols;

}
