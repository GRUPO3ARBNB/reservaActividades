package com.reservas.actividades.service.impl;

import com.reservas.actividades.model.DetalleTipoPlan;
import com.reservas.actividades.repository.IDetalleTipoPlanRepository;
import com.reservas.actividades.service.interfaces.IDetalleTipoPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase para el manejo de vacaciones aplazadas...
 * History 2373 Crear solicitud de Disfrute de Vacaciones-enviar
 * @author Luis Cruz
 * @since 1.0
 **/

@Service
public class DetalleTipoPlanServiceImpl implements IDetalleTipoPlanService {

    private IDetalleTipoPlanRepository detalleTipoPlanRepository;

    /**
     * Obtiene todos los Detalles Tipo Plan
     **/

    @Override
    public List<DetalleTipoPlan> findAllDetalleTipoPlan() {
        return this.detalleTipoPlanRepository.findAllByOrderByIdTipoPlan();
    }

    /**
     * Consulta un Detalle Tipo Plan
     **/

    @Override
    public DetalleTipoPlan findById(Long aId) {
        return this.detalleTipoPlanRepository.findById(aId).orElse(null);
    }

    // inyecciones
    @Autowired
    public void setDetalleTipoPlanRepository(IDetalleTipoPlanRepository detalleTipoPlanRepository) {
        this.detalleTipoPlanRepository = detalleTipoPlanRepository;
    }
}
