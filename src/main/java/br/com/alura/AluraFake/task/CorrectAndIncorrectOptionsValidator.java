package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CorrectAndIncorrectOptionsValidator implements TaskValidator {

    private static final int MIN_CORRECT_OPTIONS = 2;
    private static final int MIN_INCORRECT_OPTIONS = 1;

    @Override
    public void validate(TaskDTO multipleChoicesTaskDTO) {
        final var occ = multipleChoicesTaskDTO.options().stream().collect(
                Collectors.groupingBy(ChoiceDTO::isCorrect, Collectors.counting())
        );

        if (occ.get(true) >= MIN_CORRECT_OPTIONS && occ.get(false) >= MIN_INCORRECT_OPTIONS) {
           throw new TaskValidationException("");
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.MULTIPLE_CHOICE);
    }
}
