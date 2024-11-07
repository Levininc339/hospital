package com.hospital.controller.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private TipoDocumentoResponse tipoDocumentoResponse;
    private String documento;
    private String direccion;
    private TipoPersonaResponse tipoPersonaResponse;
    private Date fecha_nacimiento;
    private String lugar_nacimiento;
    private Boolean estado_sistema;
}
