package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

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
    private Long idTipo;
    @JsonIgnore
    @OneToOne(mappedBy = "descripcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContabilidadEntity contabilidad;

}
