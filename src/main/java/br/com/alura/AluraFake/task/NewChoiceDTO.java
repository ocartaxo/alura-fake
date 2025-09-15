package br.com.alura.AluraFake.task;

import jakarta.validation.constraints.Size;

public record NewChoiceDTO(
        @Size(min = 4, max = 80, message = "Alternativa excedeu o limite de caracteres")
        String option,
        boolean isCorrect
) {
}
