package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PublishCourseUseCase {

    private final SaveCourseService saveCourseService;
    private final FindCourseService findCourseService;
    private final PublishCourseValidator validator;

    public PublishCourseUseCase(
            SaveCourseService saveCourseService,
            FindCourseService findCourseService,
            PublishCourseValidator buildingStatusValidator
    ) {
        this.saveCourseService = saveCourseService;
        this.findCourseService = findCourseService;
        this.validator = buildingStatusValidator;
    }

    @Transactional
    void execute(Long id) {
        final var course = findCourseService.findCourseById(id);

        validator.validate(course);

        course.publish();

    }
}

