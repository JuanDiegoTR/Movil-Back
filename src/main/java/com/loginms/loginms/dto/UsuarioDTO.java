package com.loginms.loginms.dto;

import com.loginms.loginms.entity.RolEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class UsuarioDTO {

    private String nombre;
    private String correo;
    private String telefono;
    private String usuario;
    private String contraseña;

}
