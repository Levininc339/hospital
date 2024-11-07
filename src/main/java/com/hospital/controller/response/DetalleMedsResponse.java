package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleMedsResponse {

    private Long id;
    private String descripcion;
    private String farmaceutica;
    private String via_administracion;
}
