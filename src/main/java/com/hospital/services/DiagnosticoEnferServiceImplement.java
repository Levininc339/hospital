package com.hospital.services;

import com.hospital.controller.request.DiagnosticoEnferRequest;
import com.hospital.controller.response.*;
import com.hospital.entitys.Diagnostico_enfermedades;
import com.hospital.entitys.Enfermedades;
import com.hospital.entitys.repository.DiagnosticoEnfermedadesRepository;
import com.hospital.services.service.DiagnosticoEnferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiagnosticoEnferServiceImplement implements DiagnosticoEnferService {

    private final DiagnosticoEnfermedadesRepository diagnosticoEnfermedadesRepository;

    @Override
    public List<Diagnostico_enfermedades> getListDiagEnfermedades(){
        return diagnosticoEnfermedadesRepository.listDiagEnf();
    }

    @Override
    public void deleteDiagEnfermedades(Long id) {
        diagnosticoEnfermedadesRepository.deleteById(id);
    }

    @Override
    public DiagnosticoEnferResponse searchDiagEnfermedades(Long id) {
        Diagnostico_enfermedades diagnosticoEnfermedades = diagnosticoEnfermedadesRepository.searchDiagEnfermedades(id);
        if (Objects.nonNull(diagnosticoEnfermedades)){
            buildDiagnosticoEnferResponse(diagnosticoEnfermedades);
        }
        return DiagnosticoEnferResponse.builder().build();
    }

    @Override
    public void saveDiagEnfermedades(DiagnosticoEnferRequest diagnosticoEnferRequest) {

        Diagnostico_enfermedades diagnosticoEnfermedades = new Diagnostico_enfermedades();
        Enfermedades enfermedades = new Enfermedades();

        if (Objects.nonNull(diagnosticoEnfermedades)){
            enfermedades.setId(diagnosticoEnferRequest.getFk_enfermedades());
            diagnosticoEnfermedades.setId(diagnosticoEnferRequest.getId());
            diagnosticoEnfermedades.setFk_enfermedades(enfermedades);
            diagnosticoEnfermedadesRepository.save(diagnosticoEnfermedades);
        }
    }

    @Override
    public void updateDiagEnfermedades(DiagnosticoEnferRequest diagnosticoEnferRequest) {

        if (Objects.nonNull(diagnosticoEnferRequest)){
            Optional<Diagnostico_enfermedades> diagnosticoEnfermedades = diagnosticoEnfermedadesRepository.findById(diagnosticoEnferRequest.getId());
            if (diagnosticoEnfermedades.isPresent()){
                Diagnostico_enfermedades diagnosticoEnfermedadesAct = buildDiagEnfermedadesEntity(diagnosticoEnferRequest);
                diagnosticoEnfermedadesRepository.save(diagnosticoEnfermedadesAct);
            }
        }
    }

    private static Diagnostico_enfermedades buildDiagEnfermedadesEntity(DiagnosticoEnferRequest diagnosticoEnferRequest) {
        return Diagnostico_enfermedades.builder()
                .id(diagnosticoEnferRequest.getId())
                .fk_enfermedades(buildEnfermedadesEntity(diagnosticoEnferRequest))
                .build();
    }

    private static Enfermedades buildEnfermedadesEntity(DiagnosticoEnferRequest diagnosticoEnferRequest) {
        return Enfermedades.builder()
                .id(diagnosticoEnferRequest.getFk_enfermedades())
                .build();
    }

    private static DiagnosticoEnferResponse buildDiagnosticoEnferResponse(Diagnostico_enfermedades diagnosticoEnfermedades) {
        return DiagnosticoEnferResponse.builder()
                .id(diagnosticoEnfermedades.getId())
                .enfermedadesResponse(buildEnfermedadesResponse(diagnosticoEnfermedades))
                .build();
    }

    private static EnfermedadesResponse buildEnfermedadesResponse(Diagnostico_enfermedades diagnosticoEnfermedades) {
        return EnfermedadesResponse.builder()
                .id(diagnosticoEnfermedades.getFk_enfermedades().getId())
                .descripcion_enfermedad(diagnosticoEnfermedades.getFk_enfermedades().getDescripcion_enfermedad())
                .tratamientoResponse(buildTratamientoResponse(diagnosticoEnfermedades))
                .build();
    }

    private static TratamientoResponse buildTratamientoResponse(Diagnostico_enfermedades diagnosticoEnfermedades) {
        return TratamientoResponse.builder()
                .id(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getId())
                .descripcion(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getDescripcion())
                .medicamentoResponse(getMedicamentoResponse(diagnosticoEnfermedades))
                .build();
    }

    private static MedicamentoResponse getMedicamentoResponse(Diagnostico_enfermedades diagnosticoEnfermedades) {
        return MedicamentoResponse.builder()
                .id(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getId())
                .descripcion(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getDescripcion())
                .fecha_creacion(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_creacion())
                .fecha_vencimiento(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_vencimiento())
                .detalleMedsResponse(buildDetalleMedsResponse(diagnosticoEnfermedades))
                .build();
    }

    private static DetalleMedsResponse buildDetalleMedsResponse(Diagnostico_enfermedades diagnosticoEnfermedades) {
        return DetalleMedsResponse.builder()
                .id(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getId())
                .descripcion(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getDescripcion())
                .farmaceutica(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getFarmaceutica())
                .via_administracion(diagnosticoEnfermedades.getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getVia_administracion())
                .build();
    }
}