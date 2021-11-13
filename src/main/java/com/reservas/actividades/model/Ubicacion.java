package com.reservas.actividades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Clase para el manejo de entidades ubicacion...
 * @author Luis Cruz
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "ubicacion", schema = "actividades")
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 5932868778536332276L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombeUbicacion;

    @Column(name = "latitud", nullable = false)
    private Long latitud;

    @Column(name = "longitud", nullable = false)
    private Long longitud;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Temporal(TemporalType.DATE)
    @Column(name = "fech_registro", nullable = false)
    private Date fechaReg;

    @JsonIgnore
    @OneToMany(mappedBy = "ubicacion", fetch = FetchType.LAZY)
    private List<Plan> planList;

}
