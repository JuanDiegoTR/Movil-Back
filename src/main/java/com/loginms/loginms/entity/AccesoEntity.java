package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "acceso")
public class AccesoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;
    @ManyToOne()
    @JoinColumn(name = "id_pantalla")
    private PantallaEntity pantalla;
    @ManyToOne()
    @JoinColumn(name = "id_rol")
    private RolEntity rol;

}
