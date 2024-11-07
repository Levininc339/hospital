package com.hospital.services.service;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.request.TratamientoRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TratamientoResponse;
import com.hospital.entitys.Persona;
import com.hospital.entitys.Tratamiento;

import java.util.List;

public interface TratamientoService {

    List<Tratamiento> getListTratamiento();
    void deleteTratamiento(Long id);
    TratamientoResponse searchTratamiento(Long id);
    void saveTratamiento(TratamientoRequest TratamientoRequest);
    void updateTratamiento(TratamientoRequest TratamientoRequest);
}
