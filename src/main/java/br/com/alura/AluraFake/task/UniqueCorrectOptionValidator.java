package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniqueCorrectOptionValidator implements TaskValidator {

    private static final int MAX_CORRECT_OPTION_NUMBER = 1;
    public static final String ERROR_MSG = "Correct options are not unique";

    @Override
    public void validate(TaskDTO dto) {
        final var optionsOccurrences = dto.options().stream().collect(
                Collectors.groupingBy(ChoiceDTO::isCorrect, Collectors.counting())
        );

        if (optionsOccurrences.get(true) > MAX_CORRECT_OPTION_NUMBER) {
            throw new TaskValidationException("options", ERROR_MSG);
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.SINGLE_CHOICE);
    }
}
