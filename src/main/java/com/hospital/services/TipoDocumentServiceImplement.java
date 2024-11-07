package com.hospital.services;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.controller.response.TipoPersonaResponse;
import com.hospital.entitys.Tipo_documento;
import com.hospital.entitys.repository.TipoDocumentoRepository;
import com.hospital.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoDocumentServiceImplement implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<Tipo_documento> getListDocumento(){
        return tipoDocumentoRepository.listDocuments();
    }

    @Override
    public void deleteTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public TipoDocumentoResponse searchTipoDocumento(Long id) {
        Tipo_documento tipoDocumento = tipoDocumentoRepository.searchTipoDocumento(id);

        if (Objects.nonNull(tipoDocumento)){
           return buildTipoDocumentoResponse(tipoDocumento);
        }
        return TipoDocumentoResponse.builder().build();
    }

    @Override
    public void saveTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {

        Tipo_documento tipoDocumento = new Tipo_documento();

        if (Objects.nonNull(tipoDocumentoRequest)){
            tipoDocumento.setDescripcion(tipoDocumentoRequest.getDescripcion());
            tipoDocumento.setSigla(tipoDocumentoRequest.getSigla());
            tipoDocumentoRepository.save(tipoDocumento);
        }
    }

    @Override
    public void updateTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {

        if (Objects.nonNull(tipoDocumentoRequest)){
            Optional <Tipo_documento> tipoDocumento = tipoDocumentoRepository.findById(tipoDocumentoRequest.getId());
            if (tipoDocumento.isPresent()){
                Tipo_documento tipo_documentoUpdate = buildTipoDocumentoEntity(tipoDocumentoRequest);
                tipoDocumentoRepository.save(tipo_documentoUpdate);
            }
        }
    }

    private static Tipo_documento buildTipoDocumentoEntity(TipoDocumentoRequest tipoDocumentoRequest) {
        return Tipo_documento.builder()
                .id(tipoDocumentoRequest.getId())
                .sigla(tipoDocumentoRequest.getSigla())
                .descripcion(tipoDocumentoRequest.getDescripcion())
                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse(Tipo_documento tipoDocumento) {
        return TipoDocumentoResponse.builder()
                .id(tipoDocumento.getId())
                .descripcion(tipoDocumento.getDescripcion())
                .sigla(tipoDocumento.getSigla())
                .build();
    }
}
