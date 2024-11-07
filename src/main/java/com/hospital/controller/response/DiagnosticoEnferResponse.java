package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoEnferResponse {

    private Long id;
    private EnfermedadesResponse enfermedadesResponse;
}
