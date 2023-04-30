package com.loginms.loginms.controller;

import com.loginms.loginms.dto.ContabilidadOutDTO;
import com.loginms.loginms.service.IOperacionesBasicasService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_OPER_BASICAS)
public class OperacionesBasicasController {

    @Autowired
    private IOperacionesBasicasService operacionesBasicasService;

    /**
     * Obtener el valor total de gastos de el usuario
     *
     * @param usuario Usuario a consultar
     * @return total de los gastos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_GAST)
    public Long gastosDeUsuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.gastosDeUsuario(usuario);
    }

    /**
     * Obtener el valor total de los ingresos de el usuario
     * @param usuario Usuario a consultar
     * @return total de los ingresos
     * @throws NullPointerException Error
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_INGRE)
    public Long ingresosDeUsuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.ingresosDeUsuario(usuario);
    }

    /**
     * Lista de los gastos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los gastos
     * @throws NullPointerException
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_GASTS)
    public List<ContabilidadOutDTO> listGastosByusuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.listGastosByusuario(usuario);
    }
    /**
     * Lista de los ingresos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los ingresos
     * @throws NullPointerException
     */
    @GetMapping(value = Constantes.Urls.PATH_OPER_BASICAS_USUARIO_INGRES)
    public List<ContabilidadOutDTO> listIngresosByusuario(@PathVariable("usuario") String usuario) throws NullPointerException{
        return operacionesBasicasService.listIngresosByusuario(usuario);
    }

}
