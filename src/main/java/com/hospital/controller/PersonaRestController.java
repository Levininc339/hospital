package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Persona;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person/v1")
@RequiredArgsConstructor
public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> listPersonApi(){
        List<Persona> personaList = personaService.getListPersons();
        return new ResponseEntity<List<Persona>>(personaList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deletePersonApi(@RequestParam(name = "id") Long id){
            personaService.deletePerson(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PersonaResponse> searchPersonApi(@PathVariable Long id){
            PersonaResponse personaResponse = personaService.searchPerson(id);
        return ResponseEntity.accepted().body(personaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePersonApi(@RequestBody PersonaRequest personaRequest){
            personaService.savePerson(personaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePersonApi(@RequestBody PersonaRequest personaRequest){
            personaService.updatePerson(personaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }




}
