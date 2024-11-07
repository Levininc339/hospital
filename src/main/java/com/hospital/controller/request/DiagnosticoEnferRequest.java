package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoEnferRequest {

    private Long id;
    private Long fk_enfermedades;
}
