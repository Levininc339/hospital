package com.hospital.services.service;

import com.hospital.controller.request.EnfermedadesRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.EnfermedadesResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Enfermedades;

import java.util.List;

public interface EnfermedadesService {
    List<Enfermedades> getListEnfermedades();
    void deleteEnfermedades(Long id);
    EnfermedadesResponse searchEnfermedades(Long id);
    void saveEnfermedades(EnfermedadesRequest enfermedadesRequest);
    void updateEnfermedades(EnfermedadesRequest enfermedadesRequest);
}
