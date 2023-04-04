package com.loginms.loginms.service;

import com.loginms.loginms.dto.ContabilidadOutDTO;

import java.util.List;

public interface IOperacionesBasicasService {

    /**
     * Obtener el valor total de gastos de el usuario
     *
     * @param usuario Usuario a consultar
     * @return total de gastos
     * @throws NullPointerException Error
     */
    Long gastosDeUsuario(String usuario) throws NullPointerException;

    /**
     * Obtener el valor total de los ingresos de el usuario
     * @param usuario Usuario a consultar
     * @return total de los ingresos
     * @throws NullPointerException Error
     */
    Long ingresosDeUsuario(String usuario) throws NullPointerException;

    /**
     * Lista de los gastos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los gastos
     * @throws NullPointerException
     */
    List<ContabilidadOutDTO> listGastosByusuario(String usuario) throws NullPointerException;
    /**
     * Lista de los ingresos por el usuario
     * @param usuario Usuario a consultar
     * @return Lista de los ingresos
     * @throws NullPointerException
     */
    List<ContabilidadOutDTO> listIngresosByusuario(String usuario) throws NullPointerException;

}
