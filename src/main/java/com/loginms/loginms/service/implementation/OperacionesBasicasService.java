package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.ContabilidadOutDTO;
import com.loginms.loginms.entity.ContabilidadEntity;
import com.loginms.loginms.repository.ContabilidadRepository;
import com.loginms.loginms.service.IOperacionesBasicasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (gastos == null) {
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
        if (ingresos == null) {
            throw new NullPointerException("El usuario no tiene ingresos registrado");
        }
        return ingresos;
    }

    @Override
    public List<ContabilidadOutDTO> listGastosByusuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }

        List<ContabilidadEntity> listGastos = contabilidadRepository.listGastosByusuario(usuario);
        if (listGastos.isEmpty()) {
            throw new NullPointerException("El usuario no tiene gastos registrado");
        }

        List<ContabilidadOutDTO> listGastosDTO = new ArrayList<>();
        for (ContabilidadEntity entity : listGastos) {
            listGastosDTO.add(new ContabilidadOutDTO(entity));
        }

        return listGastosDTO;
    }

    @Override
    public List<ContabilidadOutDTO> listIngresosByusuario(String usuario) throws NullPointerException {
        if (usuario == null || usuario.isEmpty()) {
            throw new NullPointerException("El usuario no puede ser nulo o vacio");
        }

        List<ContabilidadEntity> listIngresos = contabilidadRepository.listIngresosByusuario(usuario);
        if (listIngresos.isEmpty()) {
            throw new NullPointerException("El usuario no tiene ingresos registrado");
        }

        List<ContabilidadOutDTO> listIngresosDTO = new ArrayList<>();
        for (ContabilidadEntity entity : listIngresos) {
            listIngresosDTO.add(new ContabilidadOutDTO(entity));
        }

        return listIngresosDTO;
    }
}
