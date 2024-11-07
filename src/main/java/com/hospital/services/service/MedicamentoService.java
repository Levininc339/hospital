package com.hospital.services.service;

import com.hospital.controller.request.MedicamentoRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.HistoriaResponse;
import com.hospital.controller.response.MedicamentoResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Medicamento;

import java.util.List;

public interface MedicamentoService {

    List<Medicamento> getListMedicamento();
    void deleteMedicamento(Long id);
    MedicamentoResponse searchMedicamento(Long id);
    void saveMedicamento(MedicamentoRequest medicamentoRequest);
    void updateMedicamento(MedicamentoRequest medicamentoRequest);
}
