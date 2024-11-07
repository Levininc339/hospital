package com.hospital.services;

import com.hospital.controller.request.DiagnosticoRequest;
import com.hospital.controller.response.*;
import com.hospital.entitys.Diagnostico;
import com.hospital.entitys.Diagnostico_enfermedades;
import com.hospital.entitys.repository.DiagnosticoRepository;
import com.hospital.services.service.DiagnosticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiagnosticoServiceImplement implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;

    @Override
    public List<Diagnostico> getListDiagnostico(){
        return diagnosticoRepository.listDiagnosticos();
    }

    @Override
    public void deleteDiagnostico(Long id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    public DiagnosticoResponse searchDiagnostico(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.searchDiagnostico(id);
        if (Objects.nonNull(diagnostico)){
            buildDiagnosticoResponse(diagnostico);
        }
        return DiagnosticoResponse.builder().build();
    }

    @Override
    public void saveDiagnostico(DiagnosticoRequest diagnosticoRequest) {

        Diagnostico diagnostico = new Diagnostico();
        Diagnostico_enfermedades diagnosticoEnfermedades = new Diagnostico_enfermedades();

        if (Objects.nonNull(diagnosticoRequest)){
            diagnosticoEnfermedades.setId(diagnosticoRequest.getFk_enfermedades_diag());
            diagnostico.setId(diagnosticoRequest.getId());
            diagnostico.setDescripcion_diagnostico(diagnosticoRequest.getDescripcion_diagnostico());
            diagnostico.setFk_enfermedades_diag(diagnosticoEnfermedades);
            diagnostico.setFecha_creacion(diagnosticoRequest.getFecha_creacion());
            diagnostico.setFecha_actualizacion(diagnosticoRequest.getFecha_actualizacion());
            diagnosticoRepository.save(diagnostico);
        }

    }

    @Override
    public void updateDiagnostico(DiagnosticoRequest diagnosticoRequest) {

        if (Objects.nonNull(diagnosticoRequest)){
            Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(diagnosticoRequest.getId());
            if (diagnostico.isPresent()){
                Diagnostico diagnosticoActualizar = buildDiagnosticoEntity(diagnosticoRequest);
                diagnosticoRepository.save(diagnosticoActualizar);
            }
        }
    }

    private static Diagnostico buildDiagnosticoEntity(DiagnosticoRequest diagnosticoRequest) {
        return Diagnostico.builder()
                .id(diagnosticoRequest.getId())
                .descripcion_diagnostico(diagnosticoRequest.getDescripcion_diagnostico())
                .fk_enfermedades_diag(buildDiagnosticoEnferEntity(diagnosticoRequest))
                .fecha_creacion(diagnosticoRequest.getFecha_creacion())
                .fecha_actualizacion(diagnosticoRequest.getFecha_actualizacion())
                .build();
    }

    private static Diagnostico_enfermedades buildDiagnosticoEnferEntity(DiagnosticoRequest diagnosticoRequest) {
        return Diagnostico_enfermedades.builder()
                .id(diagnosticoRequest.getFk_enfermedades_diag())
                .build();
    }

    private static DiagnosticoResponse buildDiagnosticoResponse(Diagnostico diagnostico) {
        return DiagnosticoResponse.builder()
                .id(diagnostico.getId())
                .descripcion_diagnostico(diagnostico.getDescripcion_diagnostico())
                .diagnosticoEnferResponse(buildDiagnosticoEnferResponse(diagnostico))
                .fecha_creacion(diagnostico.getFecha_creacion())
                .fecha_actualizacion(diagnostico.getFecha_actualizacion())
                .build();
    }

    private static DiagnosticoEnferResponse buildDiagnosticoEnferResponse(Diagnostico diagnostico) {
        return DiagnosticoEnferResponse.builder()
                .id(diagnostico.getFk_enfermedades_diag().getId())
                .enfermedadesResponse(buildEnfermedadesResponse(diagnostico))
                .build();
    }

    private static EnfermedadesResponse buildEnfermedadesResponse(Diagnostico diagnostico) {
        return EnfermedadesResponse.builder()
                .id(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getId())
                .descripcion_enfermedad(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getDescripcion_enfermedad())
                .tratamientoResponse(buildTratamientoResponse(diagnostico))
                .build();
    }

    private static TratamientoResponse buildTratamientoResponse(Diagnostico diagnostico) {
        return TratamientoResponse.builder()
                .id(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getId())
                .descripcion(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getDescripcion())
                .medicamentoResponse(buildMedicamentoResponse(diagnostico))
                .build();
    }

    private static MedicamentoResponse buildMedicamentoResponse(Diagnostico diagnostico) {
        return MedicamentoResponse.builder()
                .id(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getId())
                .descripcion(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getDescripcion())
                .fecha_creacion(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_creacion())
                .fecha_vencimiento(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_vencimiento())
                .detalleMedsResponse(buildDetalleMedsResponse(diagnostico))
                .build();
    }

    private static DetalleMedsResponse buildDetalleMedsResponse(Diagnostico diagnostico) {
        return DetalleMedsResponse.builder()
                .id(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getId())
                .descripcion(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getDescripcion())
                .farmaceutica(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getFarmaceutica())
                .via_administracion(diagnostico.getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getVia_administracion())
                .build();
    }
}
