package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Clase para el manejo entidades plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "plan", schema = "actividades")
public class Plan implements Serializable {

    private static final long serialVersionUID = 4638284294876706609L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_ubicacion", nullable = false)
    private Long idUbicacion;

    @Column(name = "id_adjunto", nullable = false)
    private Long idAdjunto;

    @Column(name = "nombre", nullable = false)
    private String nombePlan;

    @Column(name = "descripcion", nullable = false)
    private String observacion;

    @Column(name = "precio_dia", nullable = false)
    private Integer precioDia;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "fech_registro", nullable = false)
    private Date fechaReg;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion", insertable = false, updatable = false)
    private Ubicacion ubicacion;

    @JsonIgnore
    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<DetalleTipoPlan> detalleTipoPlanList;

    @JsonIgnore
    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;

}
