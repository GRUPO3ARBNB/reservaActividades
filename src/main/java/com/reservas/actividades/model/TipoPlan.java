package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase para el manejo de entidades tipos de plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "tipo_plan", schema = "actividades")
public class TipoPlan implements Serializable {

    private static final long serialVersionUID = 7967020761972909689L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombeTipoPlan;

    @Column(name = "descripcion", nullable = false)
    private String observacion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoPlan", fetch = FetchType.LAZY)
    private List<TipoPlanRegistro> tipoPlanRegistroList;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoPlan", fetch = FetchType.LAZY)
    private List<DetalleTipoPlan> detalleTipoPlanList;

}
