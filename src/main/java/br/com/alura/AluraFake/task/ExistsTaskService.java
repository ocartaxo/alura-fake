package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Service;

@Service
public class ExistsTaskService {
    private final TaskRepository taskRepository;

    public ExistsTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean existsByStatement(String statement){
        return taskRepository.existsByStatementIgnoringCase(statement);
    }

    public boolean existsTaskByOrder(int order){
        return taskRepository.existsTaskByOrder(order);
    }

}
