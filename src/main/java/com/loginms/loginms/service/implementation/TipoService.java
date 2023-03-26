package com.loginms.loginms.service.implementation;

import com.loginms.loginms.entity.TipoEntity;
import com.loginms.loginms.repository.TipoRepository;
import com.loginms.loginms.service.ITipoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoService implements ITipoService {

    private final TipoRepository tipoRepository;

    @Override
    public Boolean validarTipo(Long id) throws NullPointerException {

        if (id == null) {
            throw new NullPointerException("Id validar tipo es null");
        }
        Optional<TipoEntity> tipoEntity = tipoRepository.findById(id);

        if (tipoEntity.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void guardarTipo(String tipo) throws NullPointerException {

        if (tipo.isEmpty()) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }

        ModelMapper mapper = new ModelMapper();
        TipoEntity tipoEntity = mapper.map(tipo, TipoEntity.class);
        tipoEntity.setTipo(tipo);
        tipoRepository.save(tipoEntity);
    }

    @Override
    public void eliminarTipo(Long id) throws NullPointerException {
        if (id == null || id.equals(" ")) {
            throw new NullPointerException("Los parametros de entrada no pueden ser nulo");
        }
        tipoRepository.deleteById(id);
    }
}
