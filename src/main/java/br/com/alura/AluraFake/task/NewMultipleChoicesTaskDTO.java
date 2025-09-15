package br.com.alura.AluraFake.task;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record NewMultipleChoicesTaskDTO(
        @Positive(message = "A ordem da tarefa deve ser um número positivo")
        int order,
        Long courseId,
        @Size(min = 4, max = 255, message = "O enunciado da tarefa possui quantidade de caracteres inválidos")
        String statement,
        @Size(min = 3, max = 5, message = "A tarefa possui numero de alternativas inválido")
        List<NewChoiceDTO> options

){}