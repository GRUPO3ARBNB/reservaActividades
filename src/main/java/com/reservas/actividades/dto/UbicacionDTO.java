package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase para el manejo de ubicacion...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class UbicacionDTO implements Serializable {

    private static final long serialVersionUID = -4173003881643537588L;

    private Long id;
    private String nombeUbicacion;
    private Long latitud;
    private Long longitud;
    private String municipio;
    private String departamento;
    private String pais;
}
