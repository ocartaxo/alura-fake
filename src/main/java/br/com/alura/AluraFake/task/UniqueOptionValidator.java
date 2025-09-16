package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class UniqueOptionValidator implements TaskValidator {

    public static final String ERROR_MSG = "Task can not contains repeated options";

    @Override
    public void validate(TaskDTO dto) {
        final var optionsText =  dto.options().stream().map(ChoiceDTO::option).toList();
        final var uniqueChoices = new HashSet<>(optionsText);

        if (uniqueChoices.size() < dto.options().size()) {
           throw new TaskValidationException("options", ERROR_MSG);
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.SINGLE_CHOICE,  Type.MULTIPLE_CHOICE);
    }
}
