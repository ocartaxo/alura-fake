package br.com.alura.AluraFake.task;

import org.springframework.stereotype.Service;

@Service
public class FindTaskService {

    private final TaskRepository taskRepository;

    public FindTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

}
