package com.hospital.services;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Persona;
import com.hospital.entitys.Tipo_documento;
import com.hospital.entitys.Tipo_persona;
import com.hospital.entitys.repository.PersonaRepository;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getListPersons() {
        return personaRepository.listPersons();
    }

    @Override
    public void deletePerson(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaResponse searchPerson(Long id) {
       Persona persona = personaRepository.searchPerson(id);

       if (Objects.nonNull(persona)){
          return buildPersonaResponse(persona);
       }
       return PersonaResponse.builder().build();
    }

    @Override
    public void savePerson(PersonaRequest personaRequest) {

        Persona persona = new Persona();
        Tipo_documento tipoDocumento = new Tipo_documento();
        Tipo_persona tipoPersona = new Tipo_persona();

        if(Objects.nonNull(personaRequest)) {
            tipoDocumento.setId(personaRequest.getFk_tipo_documentos());
            tipoPersona.setId(personaRequest.getFk_tipo_personas());
            persona.setNombre(personaRequest.getNombre());
            persona.setApellido(personaRequest.getApellido());
            persona.setFk_tipo_documentos(tipoDocumento);
            persona.setDocumento(personaRequest.getDocumento());
            persona.setDireccion(personaRequest.getDireccion());
            persona.setFk_tipo_personas(tipoPersona);
            persona.setFecha_nacimiento(personaRequest.getFecha_nacimiento());
            persona.setLugar_nacimiento(personaRequest.getLugar_nacimiento());
            persona.setEstado_sistema(personaRequest.getEstado_sistema());
            personaRepository.save(persona);
        }
    }

    @Override
    public void updatePerson(PersonaRequest personaRequest) {

        if(Objects.nonNull(personaRequest)) {
            Optional<Persona> persona = personaRepository.findById(personaRequest.getId());
            if (persona.isPresent()){
                Persona personaActualizar = buildPersonaEntity(personaRequest);
                personaRepository.save(personaActualizar);
            }
        }
    }

    private static Persona buildPersonaEntity(PersonaRequest personaRequest) {
        return Persona.builder()
                .id(personaRequest.getId())
                .nombre(personaRequest.getNombre())
                .apellido(personaRequest.getApellido())
                .fk_tipo_documentos(buildTipoDocumentoEntity(personaRequest))
                .documento(personaRequest.getDocumento())
                .direccion(personaRequest.getDireccion())
                .fk_tipo_personas(buildTipoPersonaEntity(personaRequest))
                .fecha_nacimiento(personaRequest.getFecha_nacimiento())
                .lugar_nacimiento(personaRequest.getLugar_nacimiento())
                .estado_sistema(personaRequest.getEstado_sistema())
                .build();
    }

    private static Tipo_persona buildTipoPersonaEntity(PersonaRequest personaRequest) {
        return Tipo_persona.builder()
                .id(personaRequest.getFk_tipo_personas())
                .build();
    }

    private static Tipo_documento buildTipoDocumentoEntity(PersonaRequest personaRequest) {
        return Tipo_documento.builder()
                .id(personaRequest.getFk_tipo_documentos())
                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse(Tipo_documento tipoDocumento){
        return TipoDocumentoResponse.builder()
                .id(tipoDocumento.getId())
                .sigla(tipoDocumento.getSigla())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }

    private static TipoPersonaResponse buildTipoPersonaResponse(Tipo_persona tipoPersona){
        return TipoPersonaResponse.builder()
                .id(tipoPersona.getId())
                .titulo(tipoPersona.getTitulo())
                .descripcion(tipoPersona.getDescripcion())
                .build();
    }

    private static PersonaResponse buildPersonaResponse(Persona persona) {
        return PersonaResponse.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .tipoDocumentoResponse(buildTipoDocumentoResponse(persona.getFk_tipo_documentos()))
                .documento(persona.getDocumento())
                .direccion(persona.getDireccion())
                .tipoPersonaResponse(buildTipoPersonaResponse(persona.getFk_tipo_personas()))
                .fecha_nacimiento(persona.getFecha_nacimiento())
                .lugar_nacimiento(persona.getLugar_nacimiento())
                .estado_sistema(persona.getEstado_sistema())
                .build();
    }

}
