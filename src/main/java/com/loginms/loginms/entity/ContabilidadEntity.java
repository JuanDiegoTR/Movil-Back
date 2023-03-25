package com.loginms.loginms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class ContabilidadEntity {
@Id
    private Long id_contabilidad;
    private Long id_usuario;
    private Long id_categoria;
    private Long id_descripcion;
    private Long id_tipo;
    private Long valor;
    private Date fecha;

}
