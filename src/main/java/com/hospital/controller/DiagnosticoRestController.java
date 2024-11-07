package com.hospital.controller;

import com.hospital.controller.request.DiagnosticoRequest;
import com.hospital.controller.response.DiagnosticoResponse;
import com.hospital.entitys.Diagnostico;
import com.hospital.services.service.DiagnosticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diagnosticos/v1")
@RequiredArgsConstructor
public class DiagnosticoRestController {

    private final DiagnosticoService diagnosticoService;

    @GetMapping("/list")
    public ResponseEntity<List<Diagnostico>> listDiagnosticoApi(){
        List<Diagnostico> diagnosticoList = diagnosticoService.getListDiagnostico();
        return new ResponseEntity<List<Diagnostico>>(diagnosticoList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteDiagnosticoApi(@RequestParam(name = "id") Long id){
        diagnosticoService.deleteDiagnostico(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<DiagnosticoResponse> searchDiagnosticoApi(@PathVariable Long id){
        DiagnosticoResponse diagnosticoResponse = diagnosticoService.searchDiagnostico(id);
        return ResponseEntity.accepted().body(diagnosticoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDiagnosticoApi(@RequestBody DiagnosticoRequest diagnosticoRequest){
        diagnosticoService.saveDiagnostico(diagnosticoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDiagnosticoApi(@RequestBody DiagnosticoRequest diagnosticoRequest){
        diagnosticoService.updateDiagnostico(diagnosticoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }
}
