package br.com.alura.AluraFake.task;

import jakarta.validation.constraints.Size;

public record ChoiceDTO(
        @Size(min = 4, max = 80, message = "Alternativa excedeu o limite de caracteres")
        String option,
        boolean isCorrect
) {
    public Choice toModel(){
        return new Choice(option, isCorrect);
    }
}
