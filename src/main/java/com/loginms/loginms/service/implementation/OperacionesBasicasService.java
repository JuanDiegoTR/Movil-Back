package com.loginms.loginms.service.implementation;

import com.loginms.loginms.repository.ContabilidadRepository;
import com.loginms.loginms.service.IOperacionesBasicasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperacionesBasicasService implements IOperacionesBasicasService {

    private final ContabilidadRepository contabilidadRepository;

    @Override
    public Long gastosDeUsuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }
        Long gastos = contabilidadRepository.gastosDeUsuario(usuario);
        if (gastos == null){
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }
        return gastos;
    }

    @Override
    public Long ingresosDeUsuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }
        Long ingresos = contabilidadRepository.ingresosDeUsuario(usuario);
        if (ingresos == null){
            throw new NullPointerException("El usuario no tiene ingresos registrado");
        }
        return ingresos;
    }
}
