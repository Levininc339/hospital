package com.hospital.entitys.repository;

import com.hospital.entitys.Tipo_documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<Tipo_documento, Long> {

    @Query(value = "SELECT * FROM tipo_documentos",nativeQuery = true)
    List<Tipo_documento> listDocuments();

    @Query(value = "SELECT * FROM tipo_documentos WHERE id=id",nativeQuery = true)
    Tipo_documento searchTipoDocumento(@Param(value = "id")Long id);
}
