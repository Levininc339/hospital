package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnfermedadesRequest {

    private Long id;
    private String descripcion_enfermedad;
    private Long fk_tratamiento;
}
