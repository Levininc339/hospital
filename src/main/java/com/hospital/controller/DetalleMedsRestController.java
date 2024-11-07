package com.hospital.controller;

import com.hospital.controller.request.DetalleMedsRequest;
import com.hospital.controller.request.DiagnosticoEnferRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.controller.response.DiagnosticoEnferResponse;
import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.entitys.Diagnostico_enfermedades;
import com.hospital.services.service.DetalleMedicamentosService;
import com.hospital.services.service.DiagnosticoEnferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detalle_medicamentos/v1")
@RequiredArgsConstructor
public class DetalleMedsRestController {

    private final DetalleMedicamentosService detalleMedicamentosService;

    @GetMapping("/list")
    public ResponseEntity<List<Detalle_medicamentos>> listDetalleMedsApi(){
        List<Detalle_medicamentos> detalleMedicamentosList = detalleMedicamentosService.getListDetalleMed();
        return new ResponseEntity<List<Detalle_medicamentos>>(detalleMedicamentosList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteDetalleMedsApi(@RequestParam(name = "id") Long id){
        detalleMedicamentosService.deleteDetalleMed(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<DetalleMedsResponse> searchDetalleMedsApi(@PathVariable Long id){
        DetalleMedsResponse detalleMedsResponse = detalleMedicamentosService.searchDetalleMed(id);
        return ResponseEntity.accepted().body(detalleMedsResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDetalleMedsApi(@RequestBody DetalleMedsRequest detalleMedsRequest){
        detalleMedicamentosService.saveDetalleMed(detalleMedsRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDetalleMedsApi(@RequestBody DetalleMedsRequest detalleMedsRequest){
        detalleMedicamentosService.updateDetalleMed(detalleMedsRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

}
