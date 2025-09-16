package br.com.alura.AluraFake.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class CreateTasksUseCase {

    private final SaveNewTaskService saveNewTaskService;

    private final TaskValidatorStrategyFactory validatorStrategyFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTasksUseCase.class);

    public CreateTasksUseCase(
            SaveNewTaskService saveNewTaskService,
            TaskValidatorStrategyFactory validatorStrategyFactory
    ) {
        this.saveNewTaskService = saveNewTaskService;
        this.validatorStrategyFactory = validatorStrategyFactory;
    }

    public void create(TaskDTO dto) {
        LOGGER.info("I=Criando nova task, type={}, dto={}", dto.type(), dto);

        final var validators = validatorStrategyFactory.getStrategyByType(dto.type());

        validators.forEach(validator -> validator.validate(dto));

        saveNewTaskService.save(dto);

    }
}
