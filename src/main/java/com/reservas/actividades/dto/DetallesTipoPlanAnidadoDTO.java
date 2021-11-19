package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
public class DetallesTipoPlanAnidadoDTO implements Serializable {

    private static final long serialVersionUID = 1272895198607417692L;

    private Long id;
    private PlanDTO plan;
    private TipoPlanDTO tipoPlan;
    private UbicacionDTO ubicacion;
    private List<TipoPlanRegistroDTO> restriccionList;

}
