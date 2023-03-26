package com.loginms.loginms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "contabilidad")
public class ContabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contabilidad;
    @Column(name = "tipo")
    private Long idTipo;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "fecha")
    private Date fecha;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_descripcion")
    private DescripcionEntity descripcion;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarios;


}
