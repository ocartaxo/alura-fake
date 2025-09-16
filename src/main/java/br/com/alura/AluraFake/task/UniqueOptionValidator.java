package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class UniqueOptionValidator implements TaskValidator {

    @Override
    public void validate(TaskDTO dto) {
        final var optionsText =  dto.options().stream().map(ChoiceDTO::option).toList();
        final var uniqueChoices = new HashSet<>(optionsText);

        if (uniqueChoices.size() < dto.options().size()) {
           throw new TaskValidationException("Task can not contains repeated options");
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.SINGLE_CHOICE,  Type.MULTIPLE_CHOICE);
    }
}
