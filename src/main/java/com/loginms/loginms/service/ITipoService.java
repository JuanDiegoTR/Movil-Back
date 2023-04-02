package com.loginms.loginms.service;

public interface ITipoService {

    /**
     * Valida si exite un tipo INGRESO o GASTO
     *
     * @param id parametro de entrada
     * @return Boolean
     * @throws NullPointerException Error
     */
    Boolean validarTipo(Long id) throws NullPointerException;

    /**
     * Crea un Tipo INGRESO o GASTO
     *
     * @param tipo Parametros de entrada
     * @throws NullPointerException Error
     */
    void guardarTipo(String tipo) throws NullPointerException;

    /**
     * Elimina un tipo INGRESO o GASTO
     *
     * @param id Id del tipo
     * @throws NullPointerException Error
     */
    void eliminarTipo(Long id) throws NullPointerException;

}
