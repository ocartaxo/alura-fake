package br.com.alura.AluraFake.task;

import java.util.List;

public interface TaskValidator {

    void validate(TaskDTO dto);

    List<Type> taskValidationType();

}
