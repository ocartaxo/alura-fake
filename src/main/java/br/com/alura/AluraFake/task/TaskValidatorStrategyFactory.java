package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TaskValidatorStrategyFactory {

    private final List<TaskValidator> strategyFactory;

    public TaskValidatorStrategyFactory(List<TaskValidator> strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    List<TaskValidator> getStrategyByType(Type type) {
        final var validators = strategyFactory.stream()
                .filter(strategy -> strategy.taskValidationType().contains(type))
                .toList();

        if (validators.isEmpty()) {
            throw new IllegalArgumentException("Strategy not found for type " + type);
        }

        return validators;
    }
}
