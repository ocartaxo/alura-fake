package br.com.alura.AluraFake.task;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record NewOpenTextTask(
        @Positive(message = "A ordem da tarefa deve ser um número positivo")
        int order,
        Long courseId,
        @Size(min = 4, max = 255, message = "O enunciado da tarefa possui quantidade de caracteres inválidos")
        String statement
) {
}
