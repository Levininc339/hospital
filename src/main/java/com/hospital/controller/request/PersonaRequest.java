package com.hospital.controller.request;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRequest {

    private Long id;
    private String nombre;
    private String apellido;
    private Long fk_tipo_documentos;
    private String documento;
    private String direccion;
    private Long fk_tipo_personas;
    private Date fecha_nacimiento;
    private String lugar_nacimiento;
    private Boolean estado_sistema;
}
