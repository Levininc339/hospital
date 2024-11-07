package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoResponse {

    private Long id;
    private String descripcion;
    private MedicamentoResponse medicamentoResponse;
}
