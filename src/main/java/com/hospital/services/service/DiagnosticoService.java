package com.hospital.services.service;

import com.hospital.controller.request.DiagnosticoRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.DiagnosticoResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    List<Diagnostico> getListDiagnostico();
    void deleteDiagnostico(Long id);
    DiagnosticoResponse searchDiagnostico(Long id);
    void saveDiagnostico(DiagnosticoRequest diagnosticoRequest);
    void updateDiagnostico(DiagnosticoRequest diagnosticoRequest);
}
