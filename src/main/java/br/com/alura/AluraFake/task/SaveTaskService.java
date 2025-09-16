package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveTaskService {
    private final TaskRepository taskRepository;
    private final CourseRepository courseRepository;

    public SaveTaskService(TaskRepository taskRepository, CourseRepository courseRepository) {
        this.taskRepository = taskRepository;
        this.courseRepository = courseRepository;
    }


    public void save(TaskDTO taskDTO) {
        final var course = courseRepository.getReferenceById(taskDTO.courseId());

        final var model = taskDTO.toModel(course);
        model.addToCourse(course);

        taskRepository.save(model);
    }

    public void shiftUpTaskOrders(TaskDTO taskDTO) {
        taskRepository.shiftOrdersUp(taskDTO.courseId(), taskDTO.order());
    }
}
