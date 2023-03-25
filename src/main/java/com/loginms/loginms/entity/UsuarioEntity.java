package com.loginms.loginms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contraseña;
    @ManyToOne()
    @JoinColumn(name = "id_rol")
    private RolEntity rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContabilidadEntity> contabilidad;

}
