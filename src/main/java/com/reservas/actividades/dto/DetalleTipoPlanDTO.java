package com.reservas.actividades.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Getter
@Setter
@NoArgsConstructor
public class DetalleTipoPlanDTO implements Serializable {

    private static final long serialVersionUID = 1961885233018622357L;

    private Long id;

    @NotNull
    private Long idPlan;

    @NotNull
    private Long idTipoPlan;

    private String nombePlan;
    private String observacionPlan;
    private Integer precioDia;
    private Integer capacidad;
    private String nombeUbicacion;
    private String municipio;
    private String departamento;
    private String pais;
    private String nombeTipoPlan;
    private String observacionTipoPlan;
    private String cadenaRestricciones;

}
