package com.hospital.services;

import com.hospital.controller.request.CentrosAtencionRequest;
import com.hospital.controller.response.CentrosAtencionResponse;
import com.hospital.entitys.Centros_atencion;
import com.hospital.entitys.repository.CentrosAtencionRepository;
import com.hospital.services.service.CentrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CentrosServiceImplement implements CentrosService {

    private final CentrosAtencionRepository centrosAtencionRepository;

    @Override
    public List<Centros_atencion> getListCentros(){
        return centrosAtencionRepository.listCentros();
    }

    @Override
    public void deleteCentros(Long id) {
        centrosAtencionRepository.deleteById(id);

    }

    @Override
    public CentrosAtencionResponse searchCentros(Long id) {

        Centros_atencion centrosAtencion = centrosAtencionRepository.searchCentrosAtencion(id);

        if (Objects.nonNull(centrosAtencion)){
            buildCentrosResponse(centrosAtencion);
        }
        return CentrosAtencionResponse.builder().build();
    }

    @Override
    public void saveCentros(CentrosAtencionRequest centrosAtencionRequest) {

        Centros_atencion centrosAtencion = new Centros_atencion();

        if (Objects.nonNull(centrosAtencionRequest)){
            centrosAtencion.setId(centrosAtencionRequest.getId());
            centrosAtencion.setNit(centrosAtencionRequest.getNit());
            centrosAtencion.setRazon_social(centrosAtencionRequest.getRazon_social());
            centrosAtencion.setEstado_sistema(centrosAtencionRequest.getEstado_sistema());
            centrosAtencionRepository.save(centrosAtencion);
        }
    }

    @Override
    public void updateCentros(CentrosAtencionRequest centrosAtencionRequest) {

        if (Objects.nonNull(centrosAtencionRequest)){
            Optional<Centros_atencion> centrosAtencion = centrosAtencionRepository.findById(centrosAtencionRequest.getId());
            if (centrosAtencion.isPresent()){
                Centros_atencion centros_atencionAct = buildCentrosEntity(centrosAtencionRequest);
                centrosAtencionRepository.save(centros_atencionAct);
            }
        }
    }

    private static Centros_atencion buildCentrosEntity(CentrosAtencionRequest centrosAtencionRequest) {
        return Centros_atencion.builder()
                .id(centrosAtencionRequest.getId())
                .nit(centrosAtencionRequest.getNit())
                .razon_social(centrosAtencionRequest.getRazon_social())
                .estado_sistema(centrosAtencionRequest.getEstado_sistema())
                .build();
    }

    private static CentrosAtencionResponse buildCentrosResponse(Centros_atencion centrosAtencion) {
        return CentrosAtencionResponse.builder()
                .id(centrosAtencion.getId())
                .nit(centrosAtencion.getNit())
                .razon_social(centrosAtencion.getRazon_social())
                .estado_sistema(centrosAtencion.getEstado_sistema())
                .build();
    }
}
