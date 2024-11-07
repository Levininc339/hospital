package com.hospital.controller;

import com.hospital.controller.request.EnfermedadesRequest;
import com.hospital.controller.response.EnfermedadesResponse;
import com.hospital.entitys.Enfermedades;
import com.hospital.services.service.EnfermedadesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enfermedades/v1")
@RequiredArgsConstructor
public class EnfermedadesRestController {

    private final EnfermedadesService enfermedadesService;

    @GetMapping("/list")
    public ResponseEntity<List<Enfermedades>> listEnfermedadesApi(){
        List<Enfermedades> enfermedadesList = enfermedadesService.getListEnfermedades();
        return new ResponseEntity<List<Enfermedades>>(enfermedadesList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteEnfermedadesApi(@RequestParam(name = "id") Long id){
        enfermedadesService.deleteEnfermedades(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<EnfermedadesResponse> searchEnfermedadesApi(@PathVariable Long id){
        EnfermedadesResponse enfermedadesResponse = enfermedadesService.searchEnfermedades(id);
        return ResponseEntity.accepted().body(enfermedadesResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEnfermedadesApi(@RequestBody EnfermedadesRequest enfermedadesRequest){
        enfermedadesService.saveEnfermedades(enfermedadesRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateEnfermedadesApi(@RequestBody EnfermedadesRequest enfermedadesRequest){
        enfermedadesService.updateEnfermedades(enfermedadesRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }
}
