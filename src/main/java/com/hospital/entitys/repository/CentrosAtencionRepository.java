package com.hospital.entitys.repository;

import com.hospital.entitys.Centros_atencion;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CentrosAtencionRepository extends JpaRepository<Centros_atencion,Long> {

    @Query(value = "SELECT * FROM centros_atencion",nativeQuery = true)
    List<Centros_atencion> listCentros();

    @Query(value = "SELECT * FROM centros_atencion WHERE id=:id",nativeQuery = true)
    Centros_atencion searchCentrosAtencion(@Param(value = "id") Long id);
}
