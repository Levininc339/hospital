package com.hospital.controller.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaResponse {

    private Long id;
    private PersonaResponse personaResponse;
    private PersonaResponse personaResponse2;
    private DiagnosticoResponse diagnosticoResponse;
    private Date fecha_creacion_historia;
    private CentrosAtencionResponse centrosAtencionResponse;
    private Boolean estado_sistema_historia;
}
