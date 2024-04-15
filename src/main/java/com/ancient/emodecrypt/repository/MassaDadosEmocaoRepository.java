package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.MassaDadosEmocaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassaDadosEmocaoRepository extends JpaRepository<MassaDadosEmocaoEntity, Long> {
    @Query(value = """
            select * from MassaDadosEmocaoEntity mde
            where massaDados = :massaDados
            """, nativeQuery = true)
    List<MassaDadosEmocaoEntity> findByMassaDados(@Param("massaDados") Long massaDados);
}