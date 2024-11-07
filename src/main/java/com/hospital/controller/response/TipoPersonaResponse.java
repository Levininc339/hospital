package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoPersonaResponse {

    private Long id;
    private String titulo;
    private String descripcion;
}
