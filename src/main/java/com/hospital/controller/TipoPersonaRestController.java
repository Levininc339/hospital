package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.request.TipoPersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Tipo_persona;
import com.hospital.services.service.TipoPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("tipoPerson/v1")
@RequestMapping
@RequiredArgsConstructor
public class TipoPersonaRestController {

    private final TipoPersonaService tipoPersonaService;

    @GetMapping("/list")
    public ResponseEntity<List<Tipo_persona>> listTipoPersonApi(){
            List<Tipo_persona> tipoPersonaList = tipoPersonaService.getListTipoPersona();
            return new ResponseEntity<List<Tipo_persona>>(tipoPersonaList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTipoPersonApi(@RequestParam(name = "id") Long id){
        tipoPersonaService.deleteTipoPerson(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<TipoPersonaResponse> searchTipoPersonApi(@PathVariable Long id){
        TipoPersonaResponse tipoPersonaResponse = tipoPersonaService.searchTipoPerson(id);
        return ResponseEntity.accepted().body(tipoPersonaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTipoPersonApi(@RequestBody TipoPersonaRequest tipoPersonaRequest){
        tipoPersonaService.saveTipoPerson(tipoPersonaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePersonApi(@RequestBody TipoPersonaRequest tipoPersonaRequest){
        tipoPersonaService.updateTipoPerson(tipoPersonaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }


}
