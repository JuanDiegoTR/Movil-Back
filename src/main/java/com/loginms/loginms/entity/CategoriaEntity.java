package com.loginms.loginms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoriaEntity {

    @Id
    private Long id_categoria;
    private String categoria;
    private Long id_tipo;
    private String id_imagen;

}
