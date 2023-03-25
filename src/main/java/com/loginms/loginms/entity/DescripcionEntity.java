package com.loginms.loginms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DescripcionEntity {

    @Id
    private Long id_descripcion;
    private String descripcion;
    private Long id_tipo;

}
