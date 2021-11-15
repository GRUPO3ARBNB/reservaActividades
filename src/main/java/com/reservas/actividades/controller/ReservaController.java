package com.reservas.actividades.controller;

import com.reservas.actividades.dto.ReservaDTO;
import com.reservas.actividades.mappers.IReservaMapper;
import com.reservas.actividades.model.Reserva;
import com.reservas.actividades.service.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private IReservaService reservaService;

    /**
     * Get all Reservas
     **/

    @GetMapping("/all")
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<Reserva> reservaList = this.reservaService.findAllReserva();
        if (reservaList == null || reservaList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reservaList.stream()
                .map(IReservaMapper.INSTANCE::toReservaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * Obtiene una Reserva de acuerdo a su ID
     * @param aId - del registro que se busca
     **/

    @GetMapping("/id/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable(value = "id") Long aId) {
        var reserva = this.reservaService.findById(aId);
        if (reserva != null) {
            return new ResponseEntity<>(IReservaMapper.INSTANCE.toReservaDTO(reserva), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Create una reserva. validate restrictions by DTO
     * @param aReservaDTO - datos de entrada para crear registro
     **/

    @PostMapping
    public ResponseEntity<ReservaDTO> createReserva(
            @Valid @RequestBody ReservaDTO aReservaDTO) {
        var reserva = this.reservaService.createReserva(IReservaMapper.INSTANCE.toReserva(aReservaDTO));
        return new ResponseEntity<>(IReservaMapper.INSTANCE.toReservaDTO(reserva), HttpStatus.CREATED);
    }

    /**
     * Actualiza una reserva.
     * @param aReservaDTO - datos del registro a actualizar
     * @return true | false
     **/

    @PutMapping
    public ResponseEntity<Boolean> updateReserva(
            @Valid @RequestBody ReservaDTO aReservaDTO) {
        this.reservaService.updateReserva(IReservaMapper.INSTANCE.toReserva(aReservaDTO));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    /**
     * Elimina una Reserva
     * @param aId - id del registro a elinimar
     **/

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteReserva(
            @PathVariable(value = "id", required = true) Long aId) {
        this.reservaService.deleteReserva(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    // inyecciones
    @Autowired
    public void setReservaService(IReservaService reservaService) {
        this.reservaService = reservaService;
    }
}
