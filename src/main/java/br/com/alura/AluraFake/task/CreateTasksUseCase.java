package br.com.alura.AluraFake.task;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class CreateTasksUseCase {

    private final SaveTaskService saveTaskService;

    private final ExistsTaskService existsTaskService;

    private final TaskValidatorStrategyFactory validatorStrategyFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTasksUseCase.class);

    public CreateTasksUseCase(
            SaveTaskService saveTaskService,
            ExistsTaskService existsTaskService,
            TaskValidatorStrategyFactory validatorStrategyFactory
    ) {
        this.saveTaskService = saveTaskService;
        this.existsTaskService = existsTaskService;
        this.validatorStrategyFactory = validatorStrategyFactory;
    }

    @Transactional
    public void execute(TaskDTO dto) {
        LOGGER.info("I=Creating a new task, type={}, dto={}", dto.type(), dto);

        final var validators = validatorStrategyFactory.getStrategyByType(dto.type());

        validators.forEach(validator -> validator.validate(dto));

        if (hasTaskWithOrder(dto)) {
            LOGGER.info("I=Shifting up tasks order");
            saveTaskService.shiftUpTaskOrders(dto);
        }

        saveTaskService.save(dto);

    }

    private boolean hasTaskWithOrder(TaskDTO taskDTO) {
        return existsTaskService.existsTaskByOrder(taskDTO.order());
    }

}
