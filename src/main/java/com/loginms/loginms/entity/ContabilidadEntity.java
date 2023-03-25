package com.loginms.loginms.entity;

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
    private Long id_tipo;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;
    @ManyToOne()
    @JoinColumn(name = "id_descripcion")
    private DescripcionEntity descripcion;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;


}
