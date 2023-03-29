package com.loginms.loginms.controller;

import com.loginms.loginms.service.ITipoService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Constantes.Urls.PATH_TIPO)
public class TipoController {

    @Autowired
    private ITipoService tipoService;

    /**
     * Crea un Tipo INGRESO o GASTO
     *
     * @param tipo Parametros de entrada
     * @throws NullPointerException Error
     */
    @PostMapping
    public void guardarTipo(@RequestParam String tipo) throws NullPointerException {
        tipoService.guardarTipo(tipo);
    }

    /**
     * Elimina un tipo INGRESO o GASTO
     *
     * @param id Id del tipo
     * @throws NullPointerException Error
     */
    @DeleteMapping(path = Constantes.Urls.PATH_TIPO_ID)
    public void eliminarTipo(@PathVariable("id") Long id) throws NullPointerException {
        tipoService.eliminarTipo(id);
    }

}
