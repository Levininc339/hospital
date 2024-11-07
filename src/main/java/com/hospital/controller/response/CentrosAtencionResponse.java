package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CentrosAtencionResponse {

    private Long id;
    private String nit;
    private String razon_social;
    private Boolean estado_sistema;
}
