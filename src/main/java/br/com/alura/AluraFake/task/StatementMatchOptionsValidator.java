package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatementMatchOptionsValidator implements TaskValidator {

    @Override
    public void validate(TaskDTO taskWihOptionsDTO) {
        final var optionsText =  taskWihOptionsDTO.options().stream().map(ChoiceDTO::option).toList();
        final var statement = taskWihOptionsDTO.statement();

        if(optionsText.stream().anyMatch(statement::equalsIgnoreCase)) {
            throw new TaskValidationException("Options can not match task statement");
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.SINGLE_CHOICE, Type.MULTIPLE_CHOICE);
    }
}
