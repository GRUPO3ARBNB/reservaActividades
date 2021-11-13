package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase para el manejo de restriccion...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "restriccion", schema = "actividades")
public class Restriccion implements Serializable {

    private static final long serialVersionUID = -4116615501756461530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombeRestriccion;

    @Column(name = "descripcion", nullable = false)
    private String observacion;

    @Column(name = "edad_minima", nullable = false)
    private Integer edadMinima;

    @Column(name = "edad_maxima", nullable = false)
    private Integer edadMaxima;

    @JsonIgnore
    @OneToMany(mappedBy = "restriccion", fetch = FetchType.LAZY)
    private List<TipoPlanRegistro> tipoPlanRegistroList;
}
