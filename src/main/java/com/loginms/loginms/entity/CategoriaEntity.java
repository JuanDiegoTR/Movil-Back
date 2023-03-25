package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "id_tipo")
    private Long id_tipo;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContabilidadEntity> contabilidad;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_imagen")
    private ImagenEntity imagen;

}
