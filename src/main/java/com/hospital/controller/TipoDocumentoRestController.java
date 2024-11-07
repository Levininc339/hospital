package com.hospital.controller;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Tipo_documento;
import com.hospital.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TipoDocumento/v1")
@RequiredArgsConstructor
public class TipoDocumentoRestController {

    private final TipoDocumentoService tipoDocumentoService;

    @GetMapping("/list")
    public ResponseEntity<List<Tipo_documento>> listTDocumentoApi(){
        List<Tipo_documento> TDocumentoList = tipoDocumentoService.getListDocumento();
        return new ResponseEntity<List<Tipo_documento>>(TDocumentoList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTipoDocumentoApi(@RequestParam(name = "id") Long id){
        tipoDocumentoService.deleteTipoDocumento(id);
       return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<TipoDocumentoResponse> searchTipoDocumentoApi(@PathVariable Long id){
            TipoDocumentoResponse tipoDocumentoResponse = tipoDocumentoService.searchTipoDocumento(id);
        return ResponseEntity.accepted().body(tipoDocumentoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTipoDocumentoApi(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
            tipoDocumentoService.saveTipoDocumento(tipoDocumentoRequest);
          return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTipoDocumentoApi(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
            tipoDocumentoService.updateTipoDocumento(tipoDocumentoRequest);
         return ResponseEntity.accepted().body("La accion fue completada correctamente");
    }

}
