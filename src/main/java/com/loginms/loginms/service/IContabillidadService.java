package com.loginms.loginms.service;

import com.loginms.loginms.dto.ContabilidadDTO;

public interface IContabillidadService {

    /**
     * Guardar un nuevo registro contable
     * @param contabilidadDTO Dto de entrada
     * @throws NullPointerException
     */
    void guardarContabillidad(ContabilidadDTO contabilidadDTO) throws NullPointerException;

    /**
     * Eliminar un registro contable
     * @param idContabilidad Id del registro a eliminar
     * @throws NullPointerException
     */
    void eliminarContabillidad(Long idContabilidad) throws NullPointerException;

    /**
     * Actualizar un registro contable
     * @param idContabilidad Id del registro a actualizar
     * @param contabilidadDTO Datos a actualizar
     * @throws NullPointerException
     */
    void actualizarContabillidad(Long idContabilidad, ContabilidadDTO contabilidadDTO) throws NullPointerException;

}
