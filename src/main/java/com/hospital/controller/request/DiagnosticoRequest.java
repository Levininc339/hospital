package com.hospital.controller.request;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoRequest {

    private Long id;
    private String descripcion_diagnostico;
    private Long fk_enfermedades_diag;
    private Date fecha_creacion;
    private Date fecha_actualizacion;
}
