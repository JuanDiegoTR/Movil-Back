package com.loginms.loginms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImagenEntity {

    @Id
    private Long id_imagen;
    private Byte[] imagen;

}
