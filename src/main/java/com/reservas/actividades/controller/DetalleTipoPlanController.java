package com.reservas.actividades.controller;

import com.reservas.actividades.dto.DetallesTipoPlanAnidadoDTO;
import com.reservas.actividades.mappers.IDetalleTipoPlanMapper;
import com.reservas.actividades.model.DetalleTipoPlan;
import com.reservas.actividades.service.interfaces.IDetalleTipoPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@RestController
@RequestMapping("/api/detallesTipoPlan")
public class DetalleTipoPlanController {

    private IDetalleTipoPlanService detalleTipoPlanService;

    /**
     * Get all Detalles Tipo Plan
     **/

    @GetMapping("/all")
    public ResponseEntity<List<DetallesTipoPlanAnidadoDTO>> findAll() {
        List<DetalleTipoPlan> detalleTipoPlanList = this.detalleTipoPlanService.findAllDetalleTipoPlan();
        if (detalleTipoPlanList == null || detalleTipoPlanList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalleTipoPlanList.stream()
                .map(IDetalleTipoPlanMapper.INSTANCE::toDetallesTipoPlanAnidadoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * Obtiene un Detalle Tipo Plan de acuerdo a su ID
     * @param aId -
     **/

    @GetMapping("/id/{id}")
    public ResponseEntity<DetallesTipoPlanAnidadoDTO> findById(@PathVariable(value = "id") Long aId) {
        var detalleTipoPlan = this.detalleTipoPlanService.findById(aId);
        if (detalleTipoPlan != null) {
            return new ResponseEntity<>(IDetalleTipoPlanMapper.INSTANCE.toDetallesTipoPlanAnidadoDTO(detalleTipoPlan), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // inyecciones
    @Autowired
    public void setDetalleTipoPlanService(IDetalleTipoPlanService detalleTipoPlanService) {
        this.detalleTipoPlanService = detalleTipoPlanService;
    }
}
