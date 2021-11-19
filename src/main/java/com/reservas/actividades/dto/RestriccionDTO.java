package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase para el manejo de restricciones...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class RestriccionDTO implements Serializable {

    private static final long serialVersionUID = 3623516175503167419L;

    private Long id;
    private String nombeRestriccion;
    private Integer edadMinima;
    private Integer edadMaxima;

}
