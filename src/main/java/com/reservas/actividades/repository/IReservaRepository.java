package com.reservas.actividades.repository;

import com.reservas.actividades.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAllByOrderByFechaRegDesc();

}
