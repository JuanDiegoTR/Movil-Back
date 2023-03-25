package com.loginms.loginms.service;

import com.loginms.loginms.dto.UsuarioDTO;
import com.loginms.loginms.entity.UsuarioEntity;

public interface IUsuarioService {

    void nuevoUsuario(UsuarioDTO usuario);
    UsuarioEntity usuarioByUsuario(String usuario);
    Boolean validarUserExist(String usuario);

}
