package com.hospital.controller.request;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaRequest {

    private Long id;
    private Long fk_persona;
    private Long fk_profesional;
    private Long fk_diagnostico_r;
    private Date fecha_creacion_historia;
    private Long fk_centro_atencion_historia;
    private Boolean estado_sistema_historia;
}
