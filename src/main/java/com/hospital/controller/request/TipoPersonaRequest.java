package com.hospital.controller.request;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoPersonaRequest {

    private Long id;
    private String titulo;
    private String descripcion;
}
