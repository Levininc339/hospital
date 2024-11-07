package com.hospital.services;

import com.hospital.controller.request.DetalleMedsRequest;
import com.hospital.controller.request.TratamientoRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.controller.response.MedicamentoResponse;
import com.hospital.controller.response.TratamientoResponse;
import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.entitys.Medicamento;
import com.hospital.entitys.Tratamiento;
import com.hospital.entitys.repository.TratamientoRepository;
import com.hospital.services.service.TratamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TratamientoServiceImplement implements TratamientoService {

    private final TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> getListTratamiento(){
        var listTratamiento = tratamientoRepository.listTratamientos();
        return listTratamiento;
    }

    @Override
    public void deleteTratamiento(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public TratamientoResponse searchTratamiento(Long id) {
        Tratamiento tratamiento = tratamientoRepository.searchTratamiento(id);

        if (Objects.nonNull(tratamiento)){
            return buildTratamientoResponse(tratamiento);
        }
        return TratamientoResponse.builder().build();
    }

    @Override
    public void saveTratamiento(TratamientoRequest tratamientoRequest) {

        Tratamiento tratamiento = new Tratamiento();
        Medicamento medicamento = new Medicamento();

        if (Objects.nonNull(tratamientoRequest)){
            medicamento.setId(tratamientoRequest.getFk_medicamento());
            tratamiento.setDescripcion(tratamientoRequest.getDescripcion());
            tratamiento.setFk_medicamento(medicamento);
            tratamientoRepository.save(tratamiento);
        }
    }

    @Override
    public void updateTratamiento(TratamientoRequest tratamientoRequest) {

        if (Objects.nonNull(tratamientoRequest)){
            Optional <Tratamiento> tratamiento = tratamientoRepository.findById(tratamientoRequest.getId());
            if (tratamiento.isPresent()){
                Tratamiento tratamientoActualizar = buildTratamientoEntity(tratamientoRequest);
                tratamientoRepository.save(tratamientoActualizar);
            }
        }
    }

    private static Tratamiento buildTratamientoEntity(TratamientoRequest tratamientoRequest) {
        return Tratamiento.builder()
                .id(tratamientoRequest.getId())
                .descripcion(tratamientoRequest.getDescripcion())
                .fk_medicamento(buildMedicamentoEntity(tratamientoRequest))
                .build();
    }

    private static Medicamento buildMedicamentoEntity(TratamientoRequest tratamientoRequest) {
        return Medicamento.builder()
                .id(tratamientoRequest.getFk_medicamento())
                .build();
    }

    private TratamientoResponse buildTratamientoResponse(Tratamiento tratamiento) {
        return TratamientoResponse.builder()
                .id(tratamiento.getId())
                .descripcion(tratamiento.getDescripcion())
                .medicamentoResponse(buildMedicamentoResponse(tratamiento.getFk_medicamento()))
                .build();
    }

    private MedicamentoResponse buildMedicamentoResponse(Medicamento medicamento){
        return MedicamentoResponse.builder()
                .id(medicamento.getId())
                .descripcion(medicamento.getDescripcion())
                .fecha_creacion(medicamento.getFecha_creacion())
                .fecha_vencimiento(medicamento.getFecha_vencimiento())
                .detalleMedsResponse(buildDetalleMedResponse(medicamento.getFk_detalle_medicamento()))
                .build();
    }

    private DetalleMedsResponse buildDetalleMedResponse(Detalle_medicamentos detalleMedicamentos){
        return DetalleMedsResponse.builder()
                .id(detalleMedicamentos.getId())
                .descripcion(detalleMedicamentos.getDescripcion())
                .farmaceutica(detalleMedicamentos.getFarmaceutica())
                .via_administracion(detalleMedicamentos.getVia_administracion())
                .build();
    }
}
