package com.hospital.services;

import com.hospital.controller.request.TipoPersonaRequest;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Tipo_persona;
import com.hospital.entitys.repository.TipoPersonaRepository;
import com.hospital.services.service.TipoPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoPersonServiceImplement implements TipoPersonaService {

    private final TipoPersonaRepository tipoPersonaRepository;

    @Override
    public List<Tipo_persona> getListTipoPersona(){
        return tipoPersonaRepository.listTipoPersons();
    }

    @Override
    public void deleteTipoPerson(Long id) {
        tipoPersonaRepository.deleteById(id);
    }

    @Override
    public TipoPersonaResponse searchTipoPerson(Long id) {
        Tipo_persona tipoPersona = tipoPersonaRepository.searchTipoPerson(id);

        if (Objects.nonNull(tipoPersona)) {
            return buildTipoPersonaResponse(tipoPersona);
        }
        return TipoPersonaResponse.builder().build();
    }

    @Override
    public void saveTipoPerson(TipoPersonaRequest tipoPersonaRequest) {

        Tipo_persona tipoPersona = new Tipo_persona();

        if (Objects.nonNull(tipoPersonaRequest)){
            tipoPersona.setDescripcion(tipoPersonaRequest.getDescripcion());
            tipoPersona.setTitulo(tipoPersonaRequest.getTitulo());
            tipoPersonaRepository.save(tipoPersona);
        }

    }

    @Override
    public void updateTipoPerson(TipoPersonaRequest tipoPersonaRequest) {

        if (Objects.nonNull(tipoPersonaRequest)){
            Optional<Tipo_persona> tipoPersona = tipoPersonaRepository.findById(tipoPersonaRequest.getId());
            if (tipoPersona.isPresent()){
                Tipo_persona tipoPersonaActualizar = buildTipoPersonaEntity(tipoPersonaRequest);
                tipoPersonaRepository.save(tipoPersonaActualizar);
            }
        }
    }

    private static Tipo_persona buildTipoPersonaEntity(TipoPersonaRequest tipoPersonaRequest) {
        return Tipo_persona.builder()
                .id(tipoPersonaRequest.getId())
                .descripcion(tipoPersonaRequest.getDescripcion())
                .titulo(tipoPersonaRequest.getTitulo())
                .build();
    }

    private static TipoPersonaResponse buildTipoPersonaResponse(Tipo_persona tipoPersona) {
        return TipoPersonaResponse.builder()
                .descripcion(tipoPersona.getDescripcion())
                .id(tipoPersona.getId())
                .titulo(tipoPersona.getTitulo())
                .build();
    }
}
