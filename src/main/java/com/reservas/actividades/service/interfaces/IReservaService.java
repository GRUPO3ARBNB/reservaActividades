package com.reservas.actividades.service.interfaces;

import com.reservas.actividades.model.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Service
public interface IReservaService {

    List<Reserva> findAllReserva();

    Reserva findById(Long aId);

    Reserva createReserva(Reserva aReserva);

    Reserva updateReserva(Reserva aReserva);

    void deleteReserva(Long aId);

}
