package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.request.TratamientoRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TratamientoResponse;
import com.hospital.entitys.Persona;
import com.hospital.entitys.Tratamiento;
import com.hospital.services.service.TratamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tratamiento/v1")
@RequiredArgsConstructor
public class TratamientoRestController {

    private final TratamientoService tratamientoService;

    @GetMapping("/list")
    public ResponseEntity<List<Tratamiento>> listTratamientoApi(){
        List<Tratamiento> tratamientoList = tratamientoService.getListTratamiento();
        return new ResponseEntity<List<Tratamiento>>(tratamientoList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTratamientoApi(@RequestParam(name = "id") Long id){
        tratamientoService.deleteTratamiento(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<TratamientoResponse> searchTratamientiApi(@PathVariable Long id){
            TratamientoResponse tratamientoResponse = tratamientoService.searchTratamiento(id);
        return ResponseEntity.accepted().body(tratamientoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTratamientoApi(@RequestBody TratamientoRequest tratamientoRequest){
        tratamientoService.saveTratamiento(tratamientoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTratamientoApi(@RequestBody TratamientoRequest tratamientoRequest){
        tratamientoService.updateTratamiento(tratamientoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

}
