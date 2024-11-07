package com.hospital.entitys.repository;

import com.hospital.entitys.Detalle_medicamentos;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleMedicamentosRepository extends JpaRepository<Detalle_medicamentos,Long> {

    @Query(value = "SELECT * FROM detalle_medicamentos",nativeQuery = true)
    List<Detalle_medicamentos> listDetalle();

    @Query(value = "SELECT * FROM detalle_medicamentos WHERE id=:id",nativeQuery = true)
    Detalle_medicamentos searchDetalleMed(@Param(value = "id") Long id);
}
