package com.hospital.services.service;

import com.hospital.controller.request.HistoriaRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.HistoriaResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Historia_clinica;

import java.util.List;

public interface HistoriaService {
    List<Historia_clinica> getListHistoria();
    void deleteHistoria(Long id);
    HistoriaResponse searchHistoria(Long id);
    void saveHistoria(HistoriaRequest historiaRequest);
    void updateHistoria(HistoriaRequest historiaRequest);
}
