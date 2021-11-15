package com.reservas.actividades.service.interfaces;

import com.reservas.actividades.model.DetalleTipoPlan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Service
public interface IDetalleTipoPlanService {

    List<DetalleTipoPlan> findAllDetalleTipoPlan();

    DetalleTipoPlan findById(Long aId);
}
