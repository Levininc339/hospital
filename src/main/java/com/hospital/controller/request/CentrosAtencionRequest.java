package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CentrosAtencionRequest {

    private Long id;
    private String nit;
    private String razon_social;
    private Boolean estado_sistema;
}
