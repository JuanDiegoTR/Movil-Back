package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.ContabilidadDTO;
import com.loginms.loginms.entity.CategoriaEntity;
import com.loginms.loginms.entity.ContabilidadEntity;
import com.loginms.loginms.entity.DescripcionEntity;
import com.loginms.loginms.entity.UsuarioEntity;
import com.loginms.loginms.repository.ContabilidadRepository;
import com.loginms.loginms.service.IContabillidadService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ContabillidadService implements IContabillidadService {

    private final ContabilidadRepository contabilidadRepository;


    @Override
    public void guardarContabillidad(ContabilidadDTO contabilidadDTO) throws NullPointerException {
        if (Objects.isNull(contabilidadDTO)) {
            throw new NullPointerException("Parametro de entrada no puede ser nulo");
        }

        ModelMapper mapper = new ModelMapper();
        ContabilidadEntity contabilidadEntity = mapper.map(contabilidadDTO, ContabilidadEntity.class);
        contabilidadEntity.setFecha(new Date());
        contabilidadEntity.setCategoria(
                new CategoriaEntity(contabilidadDTO.getIdCategoria())
        );
        contabilidadEntity.setDescripcion(
                new DescripcionEntity(contabilidadDTO.getIdDescripcion())
        );
        contabilidadEntity.setUsuarios(
                new UsuarioEntity(contabilidadDTO.getIdUsuario())
        );
        contabilidadRepository.save(contabilidadEntity);
    }

    @Override
    public void eliminarContabillidad(Long idContabilidad) throws NullPointerException {
        if (idContabilidad == null || idContabilidad.equals(" ")) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }
        contabilidadRepository.deleteById(idContabilidad);
    }

    @Override
    public void actualizarContabillidad(Long idContabilidad, ContabilidadDTO contabilidadDTO) throws NullPointerException {
        if (idContabilidad == null || idContabilidad.equals(" ") || Objects.isNull(contabilidadDTO)) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }

        ContabilidadEntity entity = contabilidadRepository.findById(idContabilidad).orElse(null);
        if (Objects.isNull(entity)) {
            throw new NullPointerException("El registro contable no existe");
        }

        ModelMapper mapper = new ModelMapper();
        ContabilidadEntity contabilidad = mapper.map(entity, ContabilidadEntity.class);
        contabilidad.setValor(contabilidadDTO.getValor());
        contabilidad.setIdTipo(contabilidadDTO.getIdTipo());
        contabilidad.setFecha(new Date());
        contabilidad.setCategoria(
                new CategoriaEntity(contabilidadDTO.getIdCategoria())
        );
        contabilidad.setDescripcion(
                new DescripcionEntity(contabilidadDTO.getIdDescripcion())
        );
        contabilidad.setUsuarios(
                new UsuarioEntity(contabilidadDTO.getIdUsuario())
        );
        contabilidadRepository.save(contabilidad);
    }
}
