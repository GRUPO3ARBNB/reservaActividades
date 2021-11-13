package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase para el manejo de entidades reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "reserva", schema = "actividades")
public class Reserva implements Serializable {

    private static final long serialVersionUID = -4403716977820255662L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_plan", nullable = false)
    private Long idPlan;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "cantidad_personas", nullable = false)
    private Integer catidadPersonas;

    @Temporal(TemporalType.DATE)
    @Column(name = "fech_registro", nullable = false)
    private Date fechaReg;

    @Temporal(TemporalType.DATE)
    @Column(name = "fech_desde", nullable = false)
    private Date fechaDesde;

    @Temporal(TemporalType.DATE)
    @Column(name = "fech_hasta", nullable = false)
    private Date fechaHasta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan", insertable = false, updatable = false)
    private Plan plan;

}
