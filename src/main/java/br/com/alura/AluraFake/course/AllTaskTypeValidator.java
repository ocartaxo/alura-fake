package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.task.Task;
import br.com.alura.AluraFake.task.Type;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AllTaskTypeValidator implements PublishCourseValidator {

    public static final String ERROR_MSG = "Course not contains all task types";
    private final PublishCourseValidator nextValidator;

    public AllTaskTypeValidator(PublishCourseValidator taskOrderValidator) {
        this.nextValidator = taskOrderValidator;
    }


    @Override
    public void validate(Course course) {

        final var courseTasksType = course.getTasks().stream().map(Task::getTaskType).collect(Collectors.toSet());

        if(!courseTasksType.containsAll(taskTypes())) {
            throw new CourseValidationException(ERROR_MSG);
        }

        nextValidator.validate(course);
    }

    private Set<Type> taskTypes() {
        return Set.of(Type.values());
    }

}
