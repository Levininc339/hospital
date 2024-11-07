package com.hospital.controller;

import com.hospital.controller.request.DiagnosticoEnferRequest;
import com.hospital.controller.request.DiagnosticoRequest;
import com.hospital.controller.response.DiagnosticoEnferResponse;
import com.hospital.controller.response.DiagnosticoResponse;
import com.hospital.entitys.Diagnostico;
import com.hospital.entitys.Diagnostico_enfermedades;
import com.hospital.services.service.DiagnosticoEnferService;
import com.hospital.services.service.DiagnosticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diagnostico_enfermedades/v1")
@RequiredArgsConstructor
public class DiagnosticoEnferRestController {

    private final DiagnosticoEnferService diagnosticoEnferService;

    @GetMapping("/list")
    public ResponseEntity<List<Diagnostico_enfermedades>> listDiagnosticoEnferApi(){
        List<Diagnostico_enfermedades> diagnosticoEnfermedadesList = diagnosticoEnferService.getListDiagEnfermedades();
        return new ResponseEntity<List<Diagnostico_enfermedades>>(diagnosticoEnfermedadesList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteDiagnosticoEnferApi(@RequestParam(name = "id") Long id){
        diagnosticoEnferService.deleteDiagEnfermedades(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<DiagnosticoEnferResponse> searchDiagnosticoEnferApi(@PathVariable Long id){
        DiagnosticoEnferResponse diagnosticoEnferResponse = diagnosticoEnferService.searchDiagEnfermedades(id);
        return ResponseEntity.accepted().body(diagnosticoEnferResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDiagnosticoEnferApi(@RequestBody DiagnosticoEnferRequest diagnosticoEnferRequest){
        diagnosticoEnferService.saveDiagEnfermedades(diagnosticoEnferRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDiagnosticoEnferApi(@RequestBody DiagnosticoEnferRequest diagnosticoEnferRequest){
        diagnosticoEnferService.updateDiagEnfermedades(diagnosticoEnferRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }
}
