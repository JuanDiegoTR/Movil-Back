package com.loginms.loginms.repository;

import com.loginms.loginms.entity.ContabilidadEntity;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContabilidadRepository extends JpaRepository<ContabilidadEntity, Long> {

    @Query(value = """
        select sum(valor) as total from contabilidad c
        inner join usuario u on u.id_usuario = c.id_usuario
        where u.usuario = :usuario
        and c.tipo = (select t.id_tipo from tipo t where t.tipo = 'GASTO')
        """, nativeQuery = true)
    Long gastosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

    @Query(value = """
        select sum(valor) as total from contabilidad c\s
        inner join usuario u on u.id_usuario = c.id_usuario
        where u.usuario = 'abc'
        and c.tipo = (select t.id_tipo from tipo t where t.tipo = 'INGRESO')
        """, nativeQuery = true)
    Long ingresosDeUsuario(@Param("usuario") String usuario) throws ConverterNotFoundException;

}
