package com.hospital.services;

import com.hospital.controller.request.EnfermedadesRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.controller.response.EnfermedadesResponse;
import com.hospital.controller.response.MedicamentoResponse;
import com.hospital.controller.response.TratamientoResponse;
import com.hospital.entitys.Enfermedades;
import com.hospital.entitys.Medicamento;
import com.hospital.entitys.Tratamiento;
import com.hospital.entitys.repository.EnfermedadesRepository;
import com.hospital.services.service.EnfermedadesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnfermedadesServiceImplement implements EnfermedadesService {

    private final EnfermedadesRepository enfermedadesRepository;

    @Override
    public List<Enfermedades> getListEnfermedades(){
        return enfermedadesRepository.listEnfermedades();
    }

    @Override
    public void deleteEnfermedades(Long id) {
        enfermedadesRepository.deleteById(id);
    }

    @Override
    public EnfermedadesResponse searchEnfermedades(Long id) {
         Enfermedades enfermedades = enfermedadesRepository.searchEnfermedades(id);

         if (Objects.nonNull(enfermedades)){
             return buildEnfermedadesResponse(enfermedades);
         }
         return EnfermedadesResponse.builder().build();
    }

    @Override
    public void saveEnfermedades(EnfermedadesRequest enfermedadesRequest) {
         Enfermedades enfermedades = new Enfermedades();
         Tratamiento tratamiento = new Tratamiento();

         if (Objects.nonNull(enfermedadesRequest)){
             tratamiento.setId(enfermedadesRequest.getFk_tratamiento());
             enfermedades.setId(enfermedadesRequest.getId());
             enfermedades.setDescripcion_enfermedad(enfermedadesRequest.getDescripcion_enfermedad());
             enfermedades.setFk_tratamiento(tratamiento);
             enfermedadesRepository.save(enfermedades);
         }
    }

    @Override
    public void updateEnfermedades(EnfermedadesRequest enfermedadesRequest) {

        if (Objects.nonNull(enfermedadesRequest)){
            Optional<Enfermedades> enfermedades = enfermedadesRepository.findById(enfermedadesRequest.getId());
            if (enfermedades.isPresent()){
                Enfermedades enfermedadesActualizar = buildEnfermedadesEntity(enfermedadesRequest);
                enfermedadesRepository.save(enfermedadesActualizar);
            }
        }
    }

    private static Enfermedades buildEnfermedadesEntity(EnfermedadesRequest enfermedadesRequest) {
        return Enfermedades.builder()
                .id(enfermedadesRequest.getId())
                .descripcion_enfermedad(enfermedadesRequest.getDescripcion_enfermedad())
                .fk_tratamiento(buildTratamientoEntity(enfermedadesRequest))
                .build();
    }

    private static Tratamiento buildTratamientoEntity(EnfermedadesRequest enfermedadesRequest) {
        return Tratamiento.builder()
                .id(enfermedadesRequest.getFk_tratamiento())
                .build();
    }

    private static EnfermedadesResponse buildEnfermedadesResponse(Enfermedades enfermedades) {
        return EnfermedadesResponse.builder()
                .id(enfermedades.getId())
                .descripcion_enfermedad(enfermedades.getDescripcion_enfermedad())
                .tratamientoResponse(buildTratamientoResponse(enfermedades))
                .build();
    }

    private static TratamientoResponse buildTratamientoResponse(Enfermedades enfermedades) {
        return TratamientoResponse.builder()
                .id(enfermedades.getFk_tratamiento().getId())
                .descripcion(enfermedades.getFk_tratamiento().getDescripcion())
                .medicamentoResponse(buildMedicamentoResponse(enfermedades.getFk_tratamiento().getFk_medicamento()))
                .build();
    }

    private static MedicamentoResponse buildMedicamentoResponse(Medicamento medicamento){
        return MedicamentoResponse.builder()
                .id(medicamento.getId())
                .descripcion(medicamento.getDescripcion())
                .fecha_creacion(medicamento.getFecha_creacion())
                .fecha_vencimiento(medicamento.getFecha_vencimiento())
                .detalleMedsResponse(DetalleMedsResponse.builder()
                        .id(medicamento.getFk_detalle_medicamento().getId())
                        .descripcion(medicamento.getFk_detalle_medicamento().getDescripcion())
                        .farmaceutica(medicamento.getFk_detalle_medicamento().getFarmaceutica())
                        .via_administracion(medicamento.getFk_detalle_medicamento().getVia_administracion())
                        .build())
                .build();
    }
}
