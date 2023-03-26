package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "acceso")
public class AccesoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;
    /*@JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_pantalla")
    private PantallaEntity pantalla;
    /*@JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_rol")
    private RolEntity rol;*/
    private Long id_pantalla;
    private Long id_rol;

}
