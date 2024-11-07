package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoResponse {

    private Long id;
    private String sigla;
    private String descripcion;
}
