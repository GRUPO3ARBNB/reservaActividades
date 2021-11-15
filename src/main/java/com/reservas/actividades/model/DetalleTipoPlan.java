package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "detalle_tipo_plan", schema = "actividades")
public class DetalleTipoPlan implements Serializable {

    private static final long serialVersionUID = 6458130956147888756L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_plan", nullable = false)
    private Long idPlan;

    @Column(name = "id_tipo_plan", nullable = false)
    private Long idTipoPlan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan", insertable = false, updatable = false)
    private Plan plan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_plan", insertable = false, updatable = false)
    private TipoPlan tipoPlan;

}
