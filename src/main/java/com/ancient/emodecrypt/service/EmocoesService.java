package com.ancient.emodecrypt.service;

import com.ancient.emodecrypt.entity.EmocoesEntity;
import com.ancient.emodecrypt.entity.MassaDadosEmocaoEntity;
import com.ancient.emodecrypt.repository.EmocoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Service
public class EmocoesService {
    @Autowired
    private EmocoesRepository emocoesRepository;

    public Boolean isExists(String nome){
        return emocoesRepository.existsByNomeEmocao(nome);
    }

    public void save(String emocao){
        emocoesRepository.save( EmocoesEntity.builder().nomeEmocao(emocao).build());
    }

    public List<String> findAllById(Long id) {
        return emocoesRepository.findEmocaoByMassaDados(id);
    }

    public List<EmocoesEntity> findAllByNomeEmocao(List<String> emocoes) {
        List<EmocoesEntity> list = new ArrayList<>();
        for (String emocao : emocoes) {
            List<EmocoesEntity> byNomeEmocao = emocoesRepository.findByNomeEmocao(emocao);
            list.addAll(byNomeEmocao);
        }
        return list;
    }

}
