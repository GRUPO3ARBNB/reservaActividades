package com.reservas.actividades.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clase para el manejo de tipo plan registro...
 * @author Luis Cruz
 * @since 1.0
 **/

@Data
@Getter
@Setter
@NoArgsConstructor
public class TipoPlanRegistroDTO implements Serializable {

    private static final long serialVersionUID = -2531651286058852172L;

    private RestriccionDTO restriccion;

}
