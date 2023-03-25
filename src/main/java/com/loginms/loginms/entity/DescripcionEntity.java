package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "descripcion")
public class DescripcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_descripcion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private Long id_tipo;
    @OneToMany(mappedBy = "descripcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContabilidadEntity> contabilidad;

}
