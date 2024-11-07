package com.hospital.controller.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoResponse {

    private Long id;
    private String descripcion;
    private Date fecha_creacion;
    private Date fecha_vencimiento;
    private DetalleMedsResponse detalleMedsResponse;
}
