package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Collections;
import java.util.List;

public record NewOpenTextTaskDTO(
        @Positive(message = "A ordem da tarefa deve ser um número positivo")
        int order,
        Long courseId,
        @Size(min = 4, max = 255, message = "O enunciado da tarefa possui quantidade de caracteres inválidos")
        String statement
) implements TaskDTO {

    @Override
    public Task toModel(Course course) {
        return new OpenTextTask(statement, order, course);
    }

    @Override
    public List<ChoiceDTO> options() {
        return Collections.emptyList();
    }
}
