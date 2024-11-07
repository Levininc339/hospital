package com.hospital.entitys.repository;

import com.hospital.entitys.Medicamento;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    @Query(value = "SELECT * FROM medicamentos", nativeQuery = true)
    List<Medicamento> listMedicamentos();

    @Query(value = "SELECT * FROM medicamentos WHERE id=:id",nativeQuery = true)
    Medicamento searchMedicamentos(@Param(value = "id") Long id);

}
