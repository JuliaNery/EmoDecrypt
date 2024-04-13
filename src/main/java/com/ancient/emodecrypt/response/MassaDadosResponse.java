package com.ancient.emodecrypt.response;

import java.util.List;

public record MassaDadosResponse(
        Long id,
        String nome,
        String comentario,
        List<String>palavrasChaves,
        String emocaoTransmitida,
        Integer nivelSatisfacao,
        Integer qtdCurtidas
) {
}
