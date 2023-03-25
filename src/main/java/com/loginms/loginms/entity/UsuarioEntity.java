package com.loginms.loginms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UsuarioEntity {

    @Id
    private Long id_usuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String usuario;
    private String contraseña;
    private String id_rol;

}
