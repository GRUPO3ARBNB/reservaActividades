package com.reservas.actividades.mappers;

import com.reservas.actividades.dto.DetalleTipoPlanDTO;
import com.reservas.actividades.model.DetalleTipoPlan;
import com.reservas.actividades.model.TipoPlanRegistro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Clase para el manejo de tabla intermedia detalle plan - tipo plan...
 * @author Luis Cruz
 * @since 1.0
 **/

@Mapper
public interface IDetalleTipoPlanMapper {

    IDetalleTipoPlanMapper INSTANCE = Mappers.getMapper(IDetalleTipoPlanMapper.class);

    // Dto's to Entitys

    /**
     * Convert DetalleTipoPlan-dto to DetalleTipoPlan
     **/

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idPlan", source = "idPlan")
    @Mapping(target = "idTipoPlan", source = "idTipoPlan")
    @Mapping(target = "plan", ignore = true)
    @Mapping(target = "tipoPlan", ignore = true)
    DetalleTipoPlan toDetalleTipoPlan(DetalleTipoPlanDTO aDetalleTipoPlanDTO);

    // Entitys to DTO's

    /**
     * Convert DetalleTipoPlan to DetalleTipoPlan-dto
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
    @Mapping(target = "nombeTipoPlan", source = "tipoPlan.nombeTipoPlan")
    @Mapping(target = "observacionTipoPlan",source = "tipoPlan.observacion")
    @Mapping(target = "cadenaRestricciones", expression = "java(getCadenaRestricciones(aDetalleTipoPlan.getTipoPlan().getTipoPlanRegistroList()))")
    DetalleTipoPlanDTO toDetalleTipoPlanDTO(DetalleTipoPlan aDetalleTipoPlan);

    default String getCadenaRestricciones(List<TipoPlanRegistro> aTipoPlanRegistroList) {
        StringBuilder cadenaRestricciones = new StringBuilder();
        if (aTipoPlanRegistroList != null
                && !aTipoPlanRegistroList.isEmpty() && aTipoPlanRegistroList.get(0) != null
                && aTipoPlanRegistroList.get(0).getRestriccion() != null) {
            for (TipoPlanRegistro tipoPlanRegistro : aTipoPlanRegistroList) {
                cadenaRestricciones.append(" - ").append(tipoPlanRegistro.getRestriccion().getNombeRestriccion());
            }
        }
        return cadenaRestricciones.toString();
    }

}
