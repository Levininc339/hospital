package com.hospital.services.service;

import com.hospital.controller.request.TipoPersonaRequest;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Tipo_persona;

import java.util.List;

public interface TipoPersonaService {

    List<Tipo_persona> getListTipoPersona();
    void deleteTipoPerson(Long id);
    TipoPersonaResponse searchTipoPerson(Long id);
    void saveTipoPerson(TipoPersonaRequest tipoPersonaRequest);
    void updateTipoPerson(TipoPersonaRequest tipoPersonaRequest);
}
