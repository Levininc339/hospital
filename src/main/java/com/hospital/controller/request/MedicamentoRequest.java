package com.hospital.controller.request;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRequest {

    private Long id;
    private String descripcion;
    private Date fecha_creacion;
    private Date fecha_vencimiento;
    private Long fk_detalle_medicamento;
}
