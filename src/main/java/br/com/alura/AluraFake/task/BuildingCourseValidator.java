package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.CourseService;
import br.com.alura.AluraFake.course.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingCourseValidator implements TaskValidator {

    private final CourseService courseService;

    private static final String ERROR_MSG = "Course with status %s can not receive tasks";

    public BuildingCourseValidator(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void validate(TaskDTO dto) {
        final var courseStatus = courseService.findCourseStatusById(dto.courseId());
        if(!Status.BUILDING.equals(courseStatus)) {
            throw new TaskValidationException(ERROR_MSG.formatted(courseStatus));
        }
    }

    @Override
    public List<Type> taskValidationType() {
        return List.of(Type.OPEN_TEXT, Type.SINGLE_CHOICE, Type.MULTIPLE_CHOICE);
    }
}
