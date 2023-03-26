package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.UsuarioDTO;
import com.loginms.loginms.entity.UsuarioEntity;
import com.loginms.loginms.repository.UsuarioRepository;
import com.loginms.loginms.service.IUsuarioService;
import com.loginms.loginms.utilities.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void nuevoUsuario(UsuarioDTO usuario) throws NullPointerException {

        if (Objects.isNull(usuario)) {
            throw new NullPointerException("El usuario no puede ser nulo");
        }

        Boolean validacion = validarUserExist(usuario.getUsuario());

        if (validacion) {
            throw new NullPointerException("El usuario ya existe");
        }

        //Encriptado
        String contraEncrip = Base64.getEncoder().encodeToString(usuario.getContraseña().getBytes());

        ModelMapper mapper = new ModelMapper();
        UsuarioEntity usuarioEntity = mapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setContraseña(contraEncrip);
        usuarioEntity.getRol().setId_rol(1L);//Bug al guardar
        System.out.println(usuarioEntity);
        usuarioRepository.save(usuarioEntity);

    }

    @Override
    public UsuarioEntity usuarioByUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("Parametro de entrada nulo o vacio");
        }
        UsuarioEntity user = usuarioRepository.findByUsuario(usuario);
        if (Objects.isNull(user)) {
            throw new NullPointerException("El usuario no existe");
        }
        return user;
    }

    @Override
    public Boolean validarUserExist(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("Parametro de entrada nulo o vacio");
        }
        UsuarioEntity usuarioByUsuario = usuarioRepository.findByUsuario(usuario);
        if (Objects.isNull(usuarioByUsuario)){
            return false;
        }

        return true;
    }
}
