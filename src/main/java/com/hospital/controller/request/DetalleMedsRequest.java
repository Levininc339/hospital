package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleMedsRequest {

    private Long id;
    private String descripcion;
    private String farmaceutica;
    private String via_administracion;
}
