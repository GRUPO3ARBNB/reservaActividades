package com.reservas.actividades.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reservas.actividades.util.IConstantes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Getter
@Setter
@NoArgsConstructor
public class ReservaDTO implements Serializable {

    private static final long serialVersionUID = -6090425525482579266L;

    private Long id;

    @NotNull
    private Long idPlan;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Integer catidadPersonas;

    @NotNull
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaReg;

    @NotNull
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaDesde;

    @NotNull
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaHasta;

    private String nombePlan;
    private String observacionPlan;
    private Integer precioDia;
    private Integer capacidad;
    private String nombeUbicacion;
    private String municipio;
    private String departamento;
    private String pais;
}
