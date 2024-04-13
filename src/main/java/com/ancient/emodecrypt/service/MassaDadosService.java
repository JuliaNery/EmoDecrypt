package com.ancient.emodecrypt.service;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.ancient.emodecrypt.repository.MassaDadosRepository;
import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.response.MassaDadosResponse;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MassaDadosService {
    @Autowired
    private MassaDadosRepository massaDadosRepository;
    @Autowired
    OpenAiChatClient gpt;

    public MassaDadosResponse create(MassaDadosRequest massaDadosRequest){

        var emocao = gpt.call("qual sentimento a mensagem " + massaDadosRequest.comentario() + " transmite. Retorne apenas o nome do sentimento");

        var massaDados = MassaDadosEntity.builder()
                .nome(massaDadosRequest.nome())
                .comentario(massaDadosRequest.comentario())
                .qtdCurtidas(massaDadosRequest.qtdCurtidas())
                .build();

        massaDadosRepository.save(massaDados);
        return null;
    }
}
