package com.loginms.loginms.service;

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

}
