package com.reservas.actividades.mappers;

import com.reservas.actividades.dto.DetalleReservaDTO;
import com.reservas.actividades.dto.DetallesTipoPlanAnidadoDTO;
import com.reservas.actividades.dto.ReservaDTO;
import com.reservas.actividades.model.DetalleTipoPlan;
import com.reservas.actividades.model.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Clase para el manejo de entidad Reserva...
 * @author Luis Cruz
 * @since 1.0
 **/

@Mapper
public interface IReservaMapper {

    IReservaMapper INSTANCE = Mappers.getMapper(IReservaMapper.class);

    // Dto's to Entitys

    /**
     * Convert Reserva-dto to Reserva
     **/

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idPlan", source = "idPlan")
    @Mapping(target = "idUsuario", source = "idUsuario")
    @Mapping(target = "catidadPersonas", source = "catidadPersonas")
    @Mapping(target = "fechaReg", source = "fechaReg")
    @Mapping(target = "fechaDesde", source = "fechaDesde")
    @Mapping(target = "fechaHasta", source = "fechaHasta")
    @Mapping(target = "plan", ignore = true)
    Reserva toReserva(ReservaDTO aReservaDTO);

    // Entitys to DTO's

    /**
     * Convert Reserva to Reserva-dto
     **/
    @InheritInverseConfiguration
    @Mapping(target = "nombePlan", source = "plan.nombePlan")
    @Mapping(target = "observacionPlan", source = "plan.observacion")
    @Mapping(target = "precioDia", source = "plan.precioDia")
    @Mapping(target = "capacidad", source = "plan.capacidad")
    @Mapping(target = "nombeUbicacion", source = "plan.ubicacion.nombeUbicacion")
    @Mapping(target = "municipio", source = "plan.ubicacion.municipio")
    @Mapping(target = "departamento", source = "plan.ubicacion.departamento")
    @Mapping(target = "pais", source = "plan.ubicacion.pais")
    ReservaDTO toReservaDTO(Reserva aReserva);

    @InheritInverseConfiguration
    @Mapping(target = "plan", source = "plan")
    @Mapping(target = "ubicacion", source = "plan.ubicacion")
    DetalleReservaDTO toDetalleReservaDTO(Reserva aReserva);
}
