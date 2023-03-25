package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "imagen")
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_imagen;
    @Column(name = "imagen")
    private Byte[] imagen;
    @OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoriaEntity> categoria;

}
