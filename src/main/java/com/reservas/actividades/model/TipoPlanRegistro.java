package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase para el manejo de tabla intermedia tipos de plan registro...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_plan_registro", schema = "actividades")
public class TipoPlanRegistro implements Serializable {

    private static final long serialVersionUID = 2708227342824260302L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_tipo_plan", nullable = false)
    private Long idTipoPlan;

    @Column(name = "id_restriccion", nullable = false)
    private Long idRestriccion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_plan", insertable = false, updatable = false)
    private TipoPlan tipoPlan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restriccion", insertable = false, updatable = false)
    private Restriccion restriccion;

}
