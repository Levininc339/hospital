package com.hospital.services.service;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.entitys.Tipo_documento;

import java.util.List;

public interface TipoDocumentoService {
    List<Tipo_documento> getListDocumento();
    void deleteTipoDocumento(Long id);
    TipoDocumentoResponse searchTipoDocumento(Long id);
    void saveTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
    void updateTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
}
