package com.hospital.services;

import com.hospital.controller.request.DetalleMedsRequest;
import com.hospital.controller.response.DetalleMedsResponse;
import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.entitys.repository.DetalleMedicamentosRepository;
import com.hospital.services.service.DetalleMedicamentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleMedicamentoServiceImplement implements DetalleMedicamentosService {

    private final DetalleMedicamentosRepository detalleMedicamentosRepository;

    @Override
    public List<Detalle_medicamentos> getListDetalleMed(){
        return detalleMedicamentosRepository.listDetalle();
    }

    @Override
    public void deleteDetalleMed(Long id) {
        detalleMedicamentosRepository.deleteById(id);
    }

    @Override
    public DetalleMedsResponse searchDetalleMed(Long id) {
        Detalle_medicamentos detalleMedicamentos = new Detalle_medicamentos();

        if (Objects.nonNull(detalleMedicamentos)){
            buildDetalleMedsResponse(detalleMedicamentos);
        }
        return DetalleMedsResponse.builder().build();
    }

    @Override
    public void saveDetalleMed(DetalleMedsRequest detalleMedsRequest) {

        Detalle_medicamentos detalleMedicamentos = new Detalle_medicamentos();

        if (Objects.nonNull(detalleMedicamentos)){
            detalleMedicamentos.setId(detalleMedsRequest.getId());
            detalleMedicamentos.setDescripcion(detalleMedsRequest.getDescripcion());
            detalleMedicamentos.setFarmaceutica(detalleMedsRequest.getFarmaceutica());
            detalleMedicamentos.setVia_administracion(detalleMedsRequest.getVia_administracion());
            detalleMedicamentosRepository.save(detalleMedicamentos);
        }
    }

    @Override
    public void updateDetalleMed(DetalleMedsRequest detalleMedsRequest) {

        if (Objects.nonNull(detalleMedsRequest)){
            Optional<Detalle_medicamentos> detalleMedicamentos = detalleMedicamentosRepository.findById(detalleMedsRequest.getId());
            if (detalleMedicamentos.isPresent()){
                Detalle_medicamentos detalle_medicamentosAct = buildDetalleMedsEntity(detalleMedsRequest);
                detalleMedicamentosRepository.save(detalle_medicamentosAct);
            }
        }
    }

    private static Detalle_medicamentos buildDetalleMedsEntity(DetalleMedsRequest detalleMedsRequest) {
        return Detalle_medicamentos.builder()
                .id(detalleMedsRequest.getId())
                .descripcion(detalleMedsRequest.getDescripcion())
                .farmaceutica(detalleMedsRequest.getFarmaceutica())
                .via_administracion(detalleMedsRequest.getVia_administracion())
                .build();
    }

    private static DetalleMedsResponse buildDetalleMedsResponse(Detalle_medicamentos detalleMedicamentos) {
        return DetalleMedsResponse.builder()
                .id(detalleMedicamentos.getId())
                .descripcion(detalleMedicamentos.getDescripcion())
                .farmaceutica(detalleMedicamentos.getFarmaceutica())
                .via_administracion(detalleMedicamentos.getVia_administracion())
                .build();
    }
}
