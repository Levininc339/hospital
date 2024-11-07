package com.hospital.services.service;

import com.hospital.controller.request.DiagnosticoEnferRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.DiagnosticoEnferResponse;
import com.hospital.controller.response.DiagnosticoResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Diagnostico_enfermedades;

import java.util.List;

public interface DiagnosticoEnferService {

    List<Diagnostico_enfermedades> getListDiagEnfermedades();
    void deleteDiagEnfermedades(Long id);
    DiagnosticoEnferResponse searchDiagEnfermedades(Long id);
    void saveDiagEnfermedades(DiagnosticoEnferRequest diagnosticoEnferRequest);
    void updateDiagEnfermedades(DiagnosticoEnferRequest diagnosticoEnferRequest);
}
