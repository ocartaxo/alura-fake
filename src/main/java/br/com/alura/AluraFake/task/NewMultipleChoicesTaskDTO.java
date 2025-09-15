package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
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
        List<ChoiceDTO> options

) implements TaskDTO {

    @Override
    public Task toModel(Course course) {
        return new MultipleChoicesTask(
                statement,
                order,
                course,
                options.stream().map(ChoiceDTO::toModel).toList()
        );
    }

    @Override
    public Type type() {
        return Type.MULTIPLE_CHOICE;
    }
}