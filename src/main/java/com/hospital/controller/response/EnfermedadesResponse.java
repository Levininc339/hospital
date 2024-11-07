package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnfermedadesResponse {

    private Long id;
    private String descripcion_enfermedad;
    private TratamientoResponse tratamientoResponse;
}
