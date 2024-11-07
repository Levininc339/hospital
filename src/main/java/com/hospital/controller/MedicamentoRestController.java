package com.hospital.controller;

import com.hospital.controller.request.MedicamentoRequest;
import com.hospital.controller.request.TratamientoRequest;
import com.hospital.controller.response.MedicamentoResponse;
import com.hospital.controller.response.TratamientoResponse;
import com.hospital.entitys.Medicamento;
import com.hospital.services.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicamento/v1")
@RequiredArgsConstructor
public class MedicamentoRestController {

    private final MedicamentoService medicamentoService;

    @GetMapping("/list")
    public ResponseEntity<List<Medicamento>> listMedicamentoApi(){
        List<Medicamento> medicamentoList = medicamentoService.getListMedicamento();
        return new ResponseEntity<List<Medicamento>>(medicamentoList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteMedicamentoApi(@RequestParam(name = "id") Long id){
        medicamentoService.deleteMedicamento(id);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<MedicamentoResponse> searchMedicamentoApi(@PathVariable Long id){
        MedicamentoResponse medicamentoResponse = medicamentoService.searchMedicamento(id);
        return ResponseEntity.accepted().body(medicamentoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMedicamentoApi(@RequestBody MedicamentoRequest medicamentoRequest){
        medicamentoService.saveMedicamento(medicamentoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateMedicamentoApi(@RequestBody MedicamentoRequest medicamentoRequest){
        medicamentoService.updateMedicamento(medicamentoRequest);
        return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }
}
