package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;

import java.util.List;

public interface TaskDTO {

    Task toModel(Course course);

    Long courseId();
    String statement();

    int order();

    List<ChoiceDTO> options();
}
