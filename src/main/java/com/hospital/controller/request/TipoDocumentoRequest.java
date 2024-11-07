package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoRequest {

    private Long id;
    private String sigla;
    private String descripcion;
}
