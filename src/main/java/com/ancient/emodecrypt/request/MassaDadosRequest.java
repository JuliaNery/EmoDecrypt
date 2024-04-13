package com.ancient.emodecrypt.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MassaDadosRequest(
        @NotBlank
        String nome,
        @NotBlank
        String comentario,
        @NotNull
        Integer qtdCurtidas

        ) {
}
