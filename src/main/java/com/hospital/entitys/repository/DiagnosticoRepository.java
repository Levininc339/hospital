package com.hospital.entitys.repository;

import com.hospital.entitys.Diagnostico;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Long> {

    @Query(value = "SELECT * FROM diagnosticos",nativeQuery = true)
    List<Diagnostico> listDiagnosticos();

    @Query(value = "SELECT * FROM diagnosticos WHERE id=:id",nativeQuery = true)
    Diagnostico searchDiagnostico(@Param(value = "id") Long id);
}
