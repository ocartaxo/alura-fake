package br.com.alura.AluraFake.task;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record NewSingleChoiceTaskDTO(
        Long courseId,
        @Size(min = 4, max = 255, message = "Tamanho inválido")
        String statement,
        @Positive(message = "Deve ser um valor positivo")
        int order,
        @Size(min = 2, max = 5, message = "Quantidade de opções inválida")
        List<NewChoiceDTO> options
) {
}
