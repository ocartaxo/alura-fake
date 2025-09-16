package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepeatedStatementTaskValidator implements TaskValidator {

    public static final String ERROR_MSG = "Task with given statement already exists";
    private final ExistsTaskService  existsTaskService;

    public RepeatedStatementTaskValidator(ExistsTaskService existsTaskService) {
        this.existsTaskService = existsTaskService;
    }

    @Override
    public void validate(TaskDTO dto) {
        if(existsTaskService.existsByStatement(dto.statement())){
            throw new TaskValidationException("statement", ERROR_MSG);
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.OPEN_TEXT, Type.SINGLE_CHOICE, Type.MULTIPLE_CHOICE);
    }
}
