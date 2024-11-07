package com.hospital.controller;

import com.hospital.controller.request.HistoriaRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.HistoriaResponse;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Historia_clinica;
import com.hospital.entitys.Persona;
import com.hospital.services.service.HistoriaService;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historia/v1")
@RequiredArgsConstructor
public class HistoriaRestController {

    private final HistoriaService historiaService;

    @GetMapping("/list")
    public ResponseEntity<List<Historia_clinica>> listHistoriaApi(){
        List<Historia_clinica> historiaClinicaList = historiaService.getListHistoria();
        return new ResponseEntity<List<Historia_clinica>>(historiaClinicaList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteHistoriaApi(@RequestParam(name = "id") Long id){
        historiaService.deleteHistoria(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<HistoriaResponse> searchHistoriaApi(@PathVariable Long id){
        HistoriaResponse historiaResponse = historiaService.searchHistoria(id);
        return ResponseEntity.accepted().body(historiaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveHistoriaApi(@RequestBody HistoriaRequest historiaRequest){
        historiaService.saveHistoria(historiaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateHistoriaApi(@RequestBody HistoriaRequest historiaRequest){
        historiaService.updateHistoria(historiaRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }
}
