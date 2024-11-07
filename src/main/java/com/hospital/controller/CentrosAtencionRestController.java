package com.hospital.controller;

import com.hospital.controller.request.CentrosAtencionRequest;
import com.hospital.controller.request.DetalleMedsRequest;
import com.hospital.controller.response.CentrosAtencionResponse;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.entitys.Centros_atencion;
import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.services.service.CentrosService;
import com.hospital.services.service.DetalleMedicamentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("centros_atencion/v1")
@RequiredArgsConstructor
public class CentrosAtencionRestController {

    private final CentrosService centrosService;

    @GetMapping("/list")
    public ResponseEntity<List<Centros_atencion>> listCentrosApi(){
        List<Centros_atencion> centrosAtencionList = centrosService.getListCentros();
        return new ResponseEntity<List<Centros_atencion>>(centrosAtencionList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteCentrosApi(@RequestParam(name = "id") Long id){
        centrosService.deleteCentros(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CentrosAtencionResponse> searchCentrosApi(@PathVariable Long id){
        CentrosAtencionResponse centrosAtencionResponse = centrosService.searchCentros(id);
        return ResponseEntity.accepted().body(centrosAtencionResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCentrosApi(@RequestBody CentrosAtencionRequest centrosAtencionRequest){
        centrosService.saveCentros(centrosAtencionRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCentrosApi(@RequestBody CentrosAtencionRequest centrosAtencionRequest){
        centrosService.updateCentros(centrosAtencionRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

}
