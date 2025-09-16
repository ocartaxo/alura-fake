package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PredecessorTaskOrderValidator implements TaskValidator {

    private final ExistsTaskService existsTaskService;

    public PredecessorTaskOrderValidator(ExistsTaskService existsTaskService) {
        this.existsTaskService = existsTaskService;
    }

    @Override
    public void validate(TaskDTO dto) {
         if (dto.order() != 1 && !existsTaskService.existsTaskByOrder(dto.order()-1)) {
            throw new TaskValidationException("Task order is invalid");
         }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.OPEN_TEXT, Type.SINGLE_CHOICE, Type.SINGLE_CHOICE);
    }
}
