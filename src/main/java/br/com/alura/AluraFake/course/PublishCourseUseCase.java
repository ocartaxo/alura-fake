package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PublishCourseUseCase {

    private final SaveCourseService saveCourseService;
    private final FindCourseService findCourseService;
    private final List<PublishCourseValidator> validators;

    public PublishCourseUseCase(
            SaveCourseService saveCourseService,
            FindCourseService findCourseService,
            List<PublishCourseValidator> validators
    ) {
        this.saveCourseService = saveCourseService;
        this.findCourseService = findCourseService;
        this.validators = validators;
    }

    @Transactional
    void execute(Long id) {
        final var course = findCourseService.findCourseById(id);

        validators.forEach(validator -> validator.validate(course));

        course.publish();

        //TODO verificar se precisa salvar o curso
    }
}

