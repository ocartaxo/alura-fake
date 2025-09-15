package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
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
        List<ChoiceDTO> options
) implements TaskDTO {
    public SingleChoiceTask toModel(Course course) {
        return new SingleChoiceTask(
                statement,
                order,
                course,
                options.stream().map(ChoiceDTO::toModel).toList()
        );
    }
}
