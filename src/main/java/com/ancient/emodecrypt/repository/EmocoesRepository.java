package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.EmocoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmocoesRepository extends JpaRepository<EmocoesEntity, Long> {
    Boolean existsByNomeEmocao(String nome);


    List<EmocoesEntity> findByNomeEmocao(String emocoes);

    @Query(value ="""
            SELECT nome_emocao FROM MASSA_DADOS_ENTITY 
            inner join MASSA_DADOS_EMOCAO_ENTITY on MASSA_DADOS_EMOCAO_ENTITY.MASSA_DADOS_ID = MASSA_DADOS_ENTITY.ID 
            inner join EMOCOES_ENTITY  on EMOCOES_ENTITY.ID = MASSA_DADOS_EMOCAO_ENTITY.EMOCOES_ID 
            where MASSA_DADOS_ENTITY.id = :id
            """, nativeQuery = true)
    List<String> findEmocaoByMassaDados(@Param("id")Long id);
}
