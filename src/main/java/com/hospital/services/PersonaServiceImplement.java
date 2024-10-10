package com.hospital.services;

import com.hospital.entitys.Persona;
import com.hospital.entitys.repository.PersonaRepository;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getListPersons() {
        var listPersons = personaRepository.listPersons();
        return listPersons;
    }
}
