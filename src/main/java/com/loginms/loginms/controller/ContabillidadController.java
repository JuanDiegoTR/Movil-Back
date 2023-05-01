package com.loginms.loginms.controller;

import com.loginms.loginms.dto.ContabilidadDTO;
import com.loginms.loginms.service.IContabillidadService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_CONTABILIDAD)
public class ContabillidadController {

    @Autowired
    private IContabillidadService contabillidadService;

    /**
     * Guardar un nuevo registro contable
     * @param contabilidadDTO Dto de entrada
     * @throws NullPointerException
     */
    @PostMapping
    public void guardarContabillidad(@RequestBody ContabilidadDTO contabilidadDTO) throws NullPointerException{
        contabillidadService.guardarContabillidad(contabilidadDTO);
    }

    /**
     * Eliminar un registro contable
     * @param idContabilidad Id del registro a eliminar
     * @throws NullPointerException
     */
    @DeleteMapping(path = Constantes.Urls.PATH_CONTABILIDAD_ID)
    public void eliminarContabillidad(@PathVariable("idContabilidad") Long idContabilidad) throws NullPointerException{
        contabillidadService.eliminarContabillidad(idContabilidad);
    }

    /**
     * Actualizar un registro contable
     * @param idContabilidad Id del registro a actualizar
     * @param contabilidadDTO Datos a actualizar
     * @throws NullPointerException
     */
    @PutMapping(path = Constantes.Urls.PATH_CONTABILIDAD_ID)
    public void actualizarContabillidad(@PathVariable("idContabilidad") Long idContabilidad,
                                        @RequestBody ContabilidadDTO contabilidadDTO) throws NullPointerException{
        contabillidadService.actualizarContabillidad(idContabilidad, contabilidadDTO);
    }

}
