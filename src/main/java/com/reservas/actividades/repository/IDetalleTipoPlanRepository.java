package com.reservas.actividades.repository;

import com.reservas.actividades.model.DetalleTipoPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Repository
public interface IDetalleTipoPlanRepository extends JpaRepository<DetalleTipoPlan, Long> {

    List<DetalleTipoPlan> findAllByOrderByIdTipoPlan();

}
