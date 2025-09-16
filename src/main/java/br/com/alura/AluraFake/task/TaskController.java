package br.com.alura.AluraFake.task;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private final CreateTasksUseCase createTasksUseCase;

    public TaskController(CreateTasksUseCase createTasksUseCase) {
        this.createTasksUseCase = createTasksUseCase;
    }

    @PostMapping("/task/new/opentext")
    public ResponseEntity newOpenTextExercise(
            @Valid @RequestBody NewOpenTextTaskDTO request
    ) {
        createTasksUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/task/new/singlechoice")
    public ResponseEntity newSingleChoice(
            @Valid @RequestBody NewSingleChoiceTaskDTO request
    ) {
        createTasksUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/task/new/multiplechoice")
    public ResponseEntity newMultipleChoice(
            @Valid @RequestBody NewMultipleChoicesTaskDTO request
    ) {
        createTasksUseCase.execute(request);
        return ResponseEntity.ok().build();
    }

}