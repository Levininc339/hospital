package com.hospital.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoRequest {

    private Long id;
    private String descripcion;
    private Long fk_medicamento;
}
