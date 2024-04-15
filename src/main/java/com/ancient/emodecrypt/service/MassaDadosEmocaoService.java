package com.ancient.emodecrypt.service;

import com.ancient.emodecrypt.entity.EmocoesEntity;
import com.ancient.emodecrypt.entity.MassaDadosEmocaoEntity;
import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.ancient.emodecrypt.repository.MassaDadosEmocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MassaDadosEmocaoService {

    @Autowired
    private MassaDadosEmocaoRepository massaDadosEmocaoRepository;

    public List<MassaDadosEmocaoEntity> findByMassaDados(Long massaDados){
       return massaDadosEmocaoRepository.findByMassaDados(massaDados);
    }

    public void save(MassaDadosEntity idMassa, List<EmocoesEntity> emocao){
       List<MassaDadosEmocaoEntity> massaDadosEmocaoEntityList =  emocao
               .stream()
               .map(e -> MassaDadosEmocaoEntity.builder()
                                                .emocoes(e)
                       .massaDados(idMassa).build()).collect(Collectors.toList());
massaDadosEmocaoRepository.saveAll(massaDadosEmocaoEntityList);
    }
}
