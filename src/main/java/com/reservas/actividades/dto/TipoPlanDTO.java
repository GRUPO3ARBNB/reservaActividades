package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase para el manejo de tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class TipoPlanDTO implements Serializable {

    private static final long serialVersionUID = 530187089523020292L;

    private Long id;
    private String nombeTipoPlan;
    private String observacion;

}
