package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase para el manejo entidad plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class PlanDTO  implements Serializable {

    private static final long serialVersionUID = -7346603206109487101L;
    private Long id;
    private Long idUbicacion;
    private Long idAdjunto;
    private String nombePlan;
    private String observacion;
    private Integer precioDia;
    private Integer capacidad;
    private Date fechaReg;
    private Boolean activo;

}
