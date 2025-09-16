package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.task.Task;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class TaskOrderValidator implements PublishCourseValidator {

    public static final String ERROR_MSG = "Tasks orders from doesn't match";

    @Override
    public void validate(Course course) {
        final var tasksOrders = course.getTasks().stream()
                .map(Task::getOrder)
                .sorted()
                .toList();


        final var expectedOrders = IntStream.range(1, tasksOrders.size()+1)
                .boxed()
                .toList();


        if(!tasksOrders.equals(expectedOrders)) {
            throw new CourseValidationException(ERROR_MSG);
        }
    }
}
