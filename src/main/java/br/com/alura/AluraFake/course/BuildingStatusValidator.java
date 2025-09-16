package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Component;

@Component
public class BuildingStatusValidator implements PublishCourseValidator {

    public static final String ERROR_MSG = "Couse with status %s can not be published";
    private final PublishCourseValidator nextValidator;

    public BuildingStatusValidator(PublishCourseValidator allTaskTypeValidator) {
        this.nextValidator = allTaskTypeValidator;
    }

    @Override
    public void validate(Course course) {
        final var status = course.getStatus();

        if(!Status.BUILDING.equals(status)) {
            throw new CourseValidatorException(ERROR_MSG.formatted(status));
        }

        nextValidator.validate(course);
    }
}
