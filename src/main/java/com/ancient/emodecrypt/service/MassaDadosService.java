package com.ancient.emodecrypt.service;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.ancient.emodecrypt.repository.MassaDadosRepository;
import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.response.MassaDadosResponse;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MassaDadosService {
    @Autowired
    private MassaDadosRepository massaDadosRepository;
    @Autowired
    private OpenAiChatClient gpt;

    public MassaDadosResponse create(MassaDadosRequest massaDadosRequest) {

        List<String> emocoes = getEmocoes(massaDadosRequest.comentario());
        Integer nivelSatisfacao = getSatisfacao(massaDadosRequest.comentario());
        List<String> palavrasChave = getPalavrasChave(massaDadosRequest.comentario());

        MassaDadosEntity massaDados = MassaDadosEntity.builder()
                .nome(massaDadosRequest.nome())
                .comentario(massaDadosRequest.comentario())
                .qtdCurtidas(massaDadosRequest.qtdCurtidas())
                .nivelSatisfacao(nivelSatisfacao)
                .palavrasChaves(palavrasChave)
                .emocaoTransmitida(emocoes)
                .tipoMassa(massaDadosRequest.tipoMassa())
                .plataformaOrigem(massaDadosRequest.plataformaOrigem())
                .build();
        massaDadosRepository.save(massaDados);
        return new MassaDadosResponse(massaDados);
    }

    private List<String> getPalavrasChave(String comentario) {
        String palavraChave = gpt.call("qual as palavras chaves que a mensagem " + comentario + " transmite. retonar apena a lista dos sentimentos separado por virgula");
        List<String> palavrasChave = new ArrayList<>();
        System.out.println(palavraChave);
        palavrasChave.addAll(List.of(palavraChave.split(", ")));
        return palavrasChave;
    }

    private Integer getSatisfacao(String comentario) {
        Integer satisfacao = Integer.valueOf(gpt.call("calcule o nivel de satisfação preciso do cliente com base no comentario '" + comentario + "' e nos sentimentos que ele transmite. RETORNAR APENAS O VALOR de 0 a 100"));
        return satisfacao;
    }

    public List<String> getEmocoes(String comentario){
        String emocao = gpt.call("qual sentimento a mensagem " + comentario + " transmite. retonar apena a lista dos sentimentos");
        List<String> emocoes = new ArrayList<>();
        emocoes.addAll(List.of(emocao.split(", ")));
        return emocoes;
    }

    public MassaDadosResponse findById(Long id) {
        var optional = massaDadosRepository.findById(id);
        var massaDados = MassaDadosEntity.builder()
                .tipoMassa(optional.get().getTipoMassa())
                .plataformaOrigem(optional.get().getPlataformaOrigem())
                .emocaoTransmitida(optional.get().getEmocaoTransmitida())
                .palavrasChaves(optional.get().getPalavrasChaves())
                .nivelSatisfacao(optional.get().getNivelSatisfacao())
                .comentario(optional.get().getComentario())
                .id(optional.get().getId())
                .nome(optional.get().getNome())
                .qtdCurtidas(optional.get().getQtdCurtidas())
                .build();
        return new MassaDadosResponse(massaDados);
    }
}
