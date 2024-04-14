package com.ancient.emodecrypt.response;

import com.ancient.emodecrypt.entity.MassaDadosEntity;

import java.util.List;

public record MassaDadosResponse(
        Long id,
        String nome,
        String comentario,
        List<String>palavrasChaves,
        List<String> emocaoTransmitida,
        Integer nivelSatisfacao,
        Integer qtdCurtidas,
        String plataformaOrigem,
        String tipoMassa,
        String empresa
) {
    public MassaDadosResponse(MassaDadosEntity massaDados, List<String> emocoes) {
        this(massaDados.getId(), massaDados.getNome(), massaDados.getComentario(), massaDados.getPalavrasChaves(),
              emocoes,  massaDados.getNivelSatisfacao(), massaDados.getQtdCurtidas(), massaDados.getPlataformaOrigem(), massaDados.getTipoMassa(), massaDados.getEmpresa());
    }
}
