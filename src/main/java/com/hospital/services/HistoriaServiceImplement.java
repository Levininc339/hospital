package com.hospital.services;

import com.hospital.controller.request.HistoriaRequest;
import com.hospital.controller.response.*;
import com.hospital.entitys.*;
import com.hospital.entitys.repository.HistoriaClinicaRepository;
import com.hospital.services.service.HistoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoriaServiceImplement implements HistoriaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public List<Historia_clinica> getListHistoria(){
        return historiaClinicaRepository.listHistoria();
    }

    @Override
    public void deleteHistoria(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    @Override
    public HistoriaResponse searchHistoria(Long id) {
        Historia_clinica historiaClinica = historiaClinicaRepository.searchHistoriaClinica(id);
        if (Objects.nonNull(historiaClinica)){
            buildHistoriaResponse(historiaClinica);
        }
        return null;
    }

    @Override
    public void saveHistoria(HistoriaRequest historiaRequest) {

        Historia_clinica historiaClinica = new Historia_clinica();
        Persona persona = new Persona();
        Persona persona1 = new Persona();
        Diagnostico diagnostico = new Diagnostico();
        Centros_atencion centrosAtencion = new Centros_atencion();

        if (Objects.nonNull(historiaRequest)){
            persona.setId(historiaRequest.getFk_persona());
            persona1.setId(historiaRequest.getFk_persona());
            diagnostico.setId(historiaRequest.getFk_diagnostico_r());
            centrosAtencion.setId(historiaRequest.getFk_centro_atencion_historia());
            historiaClinica.setFk_persona(persona);
            historiaClinica.setFk_profesional(persona1);
            historiaClinica.setFk_diagnostico_r(diagnostico);
            historiaClinica.setFecha_creacion_historia(historiaClinica.getFecha_creacion_historia());
            historiaClinica.setFk_centro_atencion_historia(centrosAtencion);
            historiaClinica.setEstado_sistema_historia(historiaClinica.getEstado_sistema_historia());
            historiaClinicaRepository.save(historiaClinica);
        }
    }

    @Override
    public void updateHistoria(HistoriaRequest historiaRequest) {

        if (Objects.nonNull(historiaRequest)){
            Optional<Historia_clinica> historiaClinica = historiaClinicaRepository.findById(historiaRequest.getId());
            if (historiaClinica.isPresent()){
                Historia_clinica historia_clinicaActualizar = buildHistoriaClinicaEntity(historiaRequest);
                historiaClinicaRepository.save(historia_clinicaActualizar);
            }
        }
    }

    private static Historia_clinica buildHistoriaClinicaEntity(HistoriaRequest historiaRequest) {
        return Historia_clinica.builder()
                .id(historiaRequest.getId())
                .fk_persona(buildPersonaEntity(historiaRequest))
                .fk_persona(builPersona2Entity(historiaRequest))
                .fk_diagnostico_r(buildDiagnosticoEntity(historiaRequest))
                .fecha_creacion_historia(historiaRequest.getFecha_creacion_historia())
                .fk_centro_atencion_historia(buildCentrosAtencionEntity(historiaRequest))
                .estado_sistema_historia(historiaRequest.getEstado_sistema_historia())
                .build();
    }

    private static Persona buildPersonaEntity(HistoriaRequest historiaRequest) {
        return Persona.builder()
                .id(historiaRequest.getFk_persona())
                .build();
    }

    private static Persona builPersona2Entity(HistoriaRequest historiaRequest) {
        return Persona.builder()
                .id(historiaRequest.getFk_persona())
                .build();
    }

    private static Diagnostico buildDiagnosticoEntity(HistoriaRequest historiaRequest) {
        return Diagnostico.builder()
                .id(historiaRequest.getFk_diagnostico_r())
                .build();
    }

    private static Centros_atencion buildCentrosAtencionEntity(HistoriaRequest historiaRequest) {
        return Centros_atencion.builder()
                .id(historiaRequest.getFk_centro_atencion_historia())
                .build();
    }

    private static HistoriaResponse buildHistoriaResponse(Historia_clinica historiaClinica) {
        return HistoriaResponse.builder()
                .id(historiaClinica.getId())
                .personaResponse(buildPersonaResponse1(historiaClinica))
                .personaResponse2(buildPersonaResponse2(historiaClinica))
                .diagnosticoResponse(buildDiagnosticoResponse(historiaClinica))
                .fecha_creacion_historia(historiaClinica.getFecha_creacion_historia())
                .centrosAtencionResponse(buildCentrosAtencionResponse(historiaClinica))
                .estado_sistema_historia(historiaClinica.getEstado_sistema_historia())
                .build();
    }

    private static CentrosAtencionResponse buildCentrosAtencionResponse(Historia_clinica historiaClinica) {
        return CentrosAtencionResponse.builder()
                .id(historiaClinica.getFk_centro_atencion_historia().getId())
                .nit(historiaClinica.getFk_centro_atencion_historia().getNit())
                .razon_social(historiaClinica.getFk_centro_atencion_historia().getRazon_social())
                .estado_sistema(historiaClinica.getFk_centro_atencion_historia().getEstado_sistema())
                .build();
    }

    private static PersonaResponse buildPersonaResponse1(Historia_clinica historiaClinica) {
        return PersonaResponse.builder()
                .id(historiaClinica.getFk_persona().getId())
                .nombre(historiaClinica.getFk_persona().getNombre())
                .apellido(historiaClinica.getFk_persona().getApellido())
                .tipoDocumentoResponse(buildTipoDocumentoResponse1(historiaClinica))
                .documento(historiaClinica.getFk_persona().getDocumento())
                .direccion(historiaClinica.getFk_persona().getDireccion())
                .tipoPersonaResponse(buildTipoPersonaResponse1(historiaClinica))
                .fecha_nacimiento(historiaClinica.getFk_persona().getFecha_nacimiento())
                .lugar_nacimiento(historiaClinica.getFk_persona().getLugar_nacimiento())
                .estado_sistema(historiaClinica.getFk_persona().getEstado_sistema())
                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse1(Historia_clinica historiaClinica) {
        return TipoDocumentoResponse.builder()
                .id(historiaClinica.getFk_persona().getFk_tipo_documentos().getId())
                .sigla(historiaClinica.getFk_persona().getFk_tipo_documentos().getSigla())
                .descripcion(historiaClinica.getFk_persona().getFk_tipo_documentos().getDescripcion())
                .build();
    }

    private static TipoPersonaResponse buildTipoPersonaResponse1(Historia_clinica historiaClinica) {
        return TipoPersonaResponse.builder()
                .id(historiaClinica.getFk_persona().getFk_tipo_personas().getId())
                .titulo(historiaClinica.getFk_persona().getFk_tipo_personas().getTitulo())
                .descripcion(historiaClinica.getFk_persona().getFk_tipo_personas().getDescripcion())
                .build();
    }

    private static PersonaResponse buildPersonaResponse2(Historia_clinica historiaClinica) {
        return PersonaResponse.builder()
                .id(historiaClinica.getFk_persona().getId())
                .nombre(historiaClinica.getFk_persona().getNombre())
                .apellido(historiaClinica.getFk_persona().getApellido())
                .tipoDocumentoResponse(buildTipoDocumentoResponse2(historiaClinica))
                .documento(historiaClinica.getFk_persona().getDocumento())
                .direccion(historiaClinica.getFk_persona().getDireccion())
                .tipoPersonaResponse(buildTipoPersonaResponse2(historiaClinica))
                .fecha_nacimiento(historiaClinica.getFk_persona().getFecha_nacimiento())
                .lugar_nacimiento(historiaClinica.getFk_persona().getLugar_nacimiento())
                .estado_sistema(historiaClinica.getFk_persona().getEstado_sistema())
                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse2(Historia_clinica historiaClinica) {
        return TipoDocumentoResponse.builder()
                .id(historiaClinica.getFk_persona().getFk_tipo_documentos().getId())
                .sigla(historiaClinica.getFk_persona().getFk_tipo_documentos().getSigla())
                .descripcion(historiaClinica.getFk_persona().getFk_tipo_documentos().getDescripcion())
                .build();
    }

    private static TipoPersonaResponse buildTipoPersonaResponse2(Historia_clinica historiaClinica) {
        return TipoPersonaResponse.builder()
                .id(historiaClinica.getFk_persona().getFk_tipo_personas().getId())
                .titulo(historiaClinica.getFk_persona().getFk_tipo_personas().getTitulo())
                .descripcion(historiaClinica.getFk_persona().getFk_tipo_personas().getDescripcion())
                .build();
    }

    private static DiagnosticoResponse buildDiagnosticoResponse(Historia_clinica historiaClinica) {
        return DiagnosticoResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getId())
                .descripcion_diagnostico(historiaClinica.getFk_diagnostico_r().getDescripcion_diagnostico())
                .diagnosticoEnferResponse(buildDiagEnferResponse(historiaClinica))
                .fecha_creacion(historiaClinica.getFk_diagnostico_r().getFecha_creacion())
                .fecha_actualizacion(historiaClinica.getFk_diagnostico_r().getFecha_actualizacion())
                .build();
    }

    private static DiagnosticoEnferResponse buildDiagEnferResponse(Historia_clinica historiaClinica) {
        return DiagnosticoEnferResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getId())
                .enfermedadesResponse(buildEnfermedadesResponse(historiaClinica))
                .build();
    }

    private static EnfermedadesResponse buildEnfermedadesResponse(Historia_clinica historiaClinica) {
        return EnfermedadesResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getId())
                .descripcion_enfermedad(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getDescripcion_enfermedad())
                .tratamientoResponse(buildTratamientoResponse(historiaClinica))
                .build();
    }

    private static TratamientoResponse buildTratamientoResponse(Historia_clinica historiaClinica) {
        return TratamientoResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getId())
                .descripcion(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getDescripcion())
                .medicamentoResponse(buildMedicamentoResponse(historiaClinica))
                .build();
    }

    private static MedicamentoResponse buildMedicamentoResponse(Historia_clinica historiaClinica) {
        return MedicamentoResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getId())
                .descripcion(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getDescripcion())
                .fecha_creacion(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_creacion())
                .fecha_vencimiento(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFecha_vencimiento())
                .detalleMedsResponse(buildDetalleMedResponse(historiaClinica))
                .build();
    }

    private static DetalleMedsResponse buildDetalleMedResponse(Historia_clinica historiaClinica) {
        return DetalleMedsResponse.builder()
                .id(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getId())
                .descripcion(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getDescripcion())
                .farmaceutica(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getFarmaceutica())
                .via_administracion(historiaClinica.getFk_diagnostico_r().getFk_enfermedades_diag().getFk_enfermedades().getFk_tratamiento().getFk_medicamento().getFk_detalle_medicamento().getVia_administracion())
                .build();
    }

}
