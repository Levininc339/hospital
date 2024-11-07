package com.hospital.services;

import com.hospital.controller.request.MedicamentoRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.controller.response.MedicamentoResponse;
import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.entitys.Medicamento;
import com.hospital.entitys.repository.MedicamentoRepository;
import com.hospital.services.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicamentoServiceImplement implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> getListMedicamento(){
        return medicamentoRepository.listMedicamentos();
    }

    @Override
    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }

    @Override
    public MedicamentoResponse searchMedicamento(Long id) {
        Medicamento medicamento = medicamentoRepository.searchMedicamentos(id);
        if (Objects.nonNull(medicamento)){
            return buildMedicamentoResponse(medicamento);
        }
        return MedicamentoResponse.builder().build();
    }

    @Override
    public void saveMedicamento(MedicamentoRequest medicamentoRequest) {

        Medicamento medicamento = new Medicamento();
        Detalle_medicamentos detalleMedicamentos = new Detalle_medicamentos();

        if (Objects.nonNull(medicamentoRequest)){
            detalleMedicamentos.setId(medicamentoRequest.getFk_detalle_medicamento());
            medicamento.setDescripcion(medicamentoRequest.getDescripcion());
            medicamento.setFecha_creacion(medicamentoRequest.getFecha_creacion());
            medicamento.setFecha_vencimiento(medicamentoRequest.getFecha_vencimiento());
            medicamento.setFk_detalle_medicamento(detalleMedicamentos);
            medicamentoRepository.save(medicamento);
        }

    }

    @Override
    public void updateMedicamento(MedicamentoRequest medicamentoRequest) {

        if (Objects.nonNull(medicamentoRequest)){
            Optional<Medicamento> medicamento = medicamentoRepository.findById(medicamentoRequest.getId());
            if (medicamento.isPresent()){
                Medicamento medicamentoActualizar = buildMedicamentoEntity(medicamentoRequest);
                medicamentoRepository.save(medicamentoActualizar);
            }
        }
    }

    private static Medicamento buildMedicamentoEntity(MedicamentoRequest medicamentoRequest) {
        return Medicamento.builder()
                .id(medicamentoRequest.getId())
                .descripcion(medicamentoRequest.getDescripcion())
                .fecha_creacion(medicamentoRequest.getFecha_creacion())
                .fecha_vencimiento(medicamentoRequest.getFecha_vencimiento())
                .fk_detalle_medicamento(buildDetalleMedicamentoEntity(medicamentoRequest))
                .build();
    }

    private static Detalle_medicamentos buildDetalleMedicamentoEntity(MedicamentoRequest medicamentoRequest) {
        return Detalle_medicamentos.builder()
                .id(medicamentoRequest.getFk_detalle_medicamento())
                .build();
    }

    private static MedicamentoResponse buildMedicamentoResponse(Medicamento medicamento) {
        return MedicamentoResponse.builder()
                .id(medicamento.getId())
                .descripcion(medicamento.getDescripcion())
                .fecha_creacion(medicamento.getFecha_creacion())
                .fecha_vencimiento(medicamento.getFecha_vencimiento())
                .detalleMedsResponse(buildDetalleMedsResponse(medicamento))
                .build();
    }

    private static DetalleMedsResponse buildDetalleMedsResponse(Medicamento medicamento) {
        return DetalleMedsResponse.builder()
                .id(medicamento.getFk_detalle_medicamento().getId())
                .descripcion(medicamento.getFk_detalle_medicamento().getDescripcion())
                .farmaceutica(medicamento.getFk_detalle_medicamento().getFarmaceutica())
                .via_administracion(medicamento.getFk_detalle_medicamento().getVia_administracion())
                .build();
    }

}
