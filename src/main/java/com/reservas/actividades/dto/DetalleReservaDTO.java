package com.reservas.actividades.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reservas.actividades.util.IConstantes;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Clase para el manejo de detalles tipo plan anidado...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class DetalleReservaDTO implements Serializable {

    private static final long serialVersionUID = 7512559713424905747L;

    private Long id;
    private Long idUsuario;
    private Integer catidadPersonas;
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaReg;
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaDesde;
    @JsonFormat(pattern = IConstantes.PATTERN_DATE_CLIENTE, timezone = IConstantes.ZONA_HORARIA_COLOMBIA)
    private Date fechaHasta;

    private PlanDTO plan;
    private UbicacionDTO ubicacion;

}
