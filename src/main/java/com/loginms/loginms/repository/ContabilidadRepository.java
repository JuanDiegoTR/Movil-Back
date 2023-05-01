package com.loginms.loginms.repository;

import com.loginms.loginms.dto.ContabilidadModalOutDTO;
import com.loginms.loginms.entity.ContabilidadEntity;
import com.loginms.loginms.entity.ContabilidadEntity;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ContabilidadRepository extends JpaRepository<ContabilidadEntity, Long> {

    @Query(value = """
        SELECT SUM(VALOR) AS TOTAL FROM CONTABILIDAD C\s
        INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
        WHERE U.USUARIO = :usuario
        AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'GASTO')
        """, nativeQuery = true)
    Long gastosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT SUM(VALOR) AS TOTAL FROM CONTABILIDAD C\s
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            WHERE U.USUARIO = :usuario
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'INGRESO')
                    """, nativeQuery = true)
    Long ingresosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;
    @Query(value = """
            SELECT
            C.ID_CONTABILIDAD,
            C.FECHA,
            C.TIPO,
            C.VALOR,	
            C.ID_CATEGORIA,
            C.ID_DESCRIPCION,
            C.ID_USUARIO
            FROM CONTABILIDAD C
            INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
            INNER JOIN CATEGORIA CA ON CA.ID_CATEGORIA = C.ID_CATEGORIA
            INNER JOIN DESCRIPCION D ON D.ID_DESCRIPCION = C.ID_DESCRIPCION
            WHERE UPPER(U.USUARIO) = UPPER(:usuario)
            AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'GASTO')
            """, nativeQuery = true)
    List<ContabilidadEntity> listGastosByusuario(String usuario) throws ConverterNotFoundException;
    @Query(value = """
    SELECT
    C.ID_CONTABILIDAD,
    C.FECHA,
    C.TIPO,
    C.VALOR,	
    C.ID_CATEGORIA,
    C.ID_DESCRIPCION,
    C.ID_USUARIO
    FROM CONTABILIDAD C
    INNER JOIN USUARIO U ON U.ID_USUARIO = C.ID_USUARIO
    INNER JOIN CATEGORIA CA ON CA.ID_CATEGORIA = C.ID_CATEGORIA
    INNER JOIN DESCRIPCION D ON D.ID_DESCRIPCION = C.ID_DESCRIPCION
    WHERE UPPER(U.USUARIO) = UPPER(:usuario)
    AND C.TIPO = (SELECT T.ID_TIPO FROM TIPO T WHERE T.TIPO = 'INGRESO')
    """, nativeQuery = true)
    List<ContabilidadEntity> listIngresosByusuario(String usuario) throws ConverterNotFoundException;

    @Query(value = """
            SELECT
            	C.ID_CONTABILIDAD AS idCont,
            	C.VALOR AS valor,
            	C.FECHA AS fecha,
            	CA.CATEGORIA AS cate,
            	D.DESCRIPCION AS descrip,
            	U.USUARIO AS usuario
            FROM
            	CONTABILIDAD C
            INNER JOIN CATEGORIA CA ON
            	CA.ID_CATEGORIA = C.ID_CATEGORIA
            INNER JOIN DESCRIPCION D ON
            	D.ID_DESCRIPCION = C.ID_DESCRIPCION
            INNER JOIN USUARIO U ON
            	U.ID_USUARIO = C.ID_USUARIO
            WHERE
            	C.ID_CONTABILIDAD = :idContabilidad
            """,nativeQuery = true)
    ContabilidadModalOutDTO getContabilidad(@Param("idContabilidad") Long idContabilidad) throws SQLException, NumberFormatException;

}
