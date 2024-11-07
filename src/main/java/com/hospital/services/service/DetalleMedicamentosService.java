package com.hospital.services.service;

import com.hospital.controller.request.DetalleMedsRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Detalle_medicamentos;

import java.util.List;

public interface DetalleMedicamentosService {
    List<Detalle_medicamentos> getListDetalleMed();
    void deleteDetalleMed(Long id);
    DetalleMedsResponse searchDetalleMed(Long id);
    void saveDetalleMed(DetalleMedsRequest detalleMedsRequest);
    void updateDetalleMed(DetalleMedsRequest detalleMedsRequest);
}
