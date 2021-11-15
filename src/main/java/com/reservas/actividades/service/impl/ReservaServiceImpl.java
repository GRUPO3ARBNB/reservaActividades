package com.reservas.actividades.service.impl;

import com.reservas.actividades.exception.DataNotFoundException;
import com.reservas.actividades.model.Reserva;
import com.reservas.actividades.repository.IReservaRepository;
import com.reservas.actividades.service.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Service
public class ReservaServiceImpl implements IReservaService {

    private IReservaRepository reservaRepository;

    /**
     * Obtiene todas Reservas
     **/

    @Override
    public List<Reserva> findAllReserva() {
        return this.reservaRepository.findAllByOrderByFechaRegDesc();
    }

    /**
     * Consulta una Reserva
     **/

    @Override
    public Reserva findById(Long aId) {
        return this.reservaRepository.findById(aId).orElse(null);
    }

    /**
     * Crea una Reserva
     **/

    @Override
    @Transactional
    public Reserva createReserva(Reserva aReserva) {
        return this.reservaRepository.save(aReserva);
    }

    /**
     * Actualiza una Reserva
     **/

    @Override
    @Transactional
    public Reserva updateReserva(Reserva aReserva) {
        Reserva reservaBD = this.reservaRepository.findById(aReserva.getId()).orElseThrow(DataNotFoundException::new);
        return this.reservaRepository.save(aReserva);
    }

    /**
     * Elimina una Reserva no sin antes verificar que existe el registro
     **/

    @Override
    @Transactional
    public void deleteReserva(Long aId) {
        Reserva reservaBD = this.reservaRepository.findById(aId).orElseThrow(DataNotFoundException::new);
        this.reservaRepository.deleteById(reservaBD.getId());
    }



    @Autowired
    public void setReservaRepository(IReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
}
