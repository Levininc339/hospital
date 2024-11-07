package com.hospital.services.service;

import com.hospital.controller.request.CentrosAtencionRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.CentrosAtencionResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Centros_atencion;

import java.util.List;

public interface CentrosService {
    List<Centros_atencion> getListCentros();
    void deleteCentros(Long id);
    CentrosAtencionResponse searchCentros(Long id);
    void saveCentros(CentrosAtencionRequest centrosAtencionRequest);
    void updateCentros(CentrosAtencionRequest centrosAtencionRequest);
}
