package com.hospital.controller.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoResponse {

    private Long id;
    private String descripcion_diagnostico;
    private DiagnosticoEnferResponse diagnosticoEnferResponse;
    private Date fecha_creacion;
    private Date fecha_actualizacion;
}
