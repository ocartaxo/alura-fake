package br.com.alura.AluraFake.user;

import br.com.alura.AluraFake.course.CourseReportDTO;
import br.com.alura.AluraFake.course.FindCourseService;
import org.springframework.stereotype.Component;

@Component
public class ReportUseCase {

    private final FindUserService findUserService;
    private final FindCourseService findCourseService;

    public ReportUseCase(
            FindUserService findUserService,
            FindCourseService findCourseService
    ) {
        this.findUserService = findUserService;
        this.findCourseService = findCourseService;
    }

    InstructorReportDTO execute(Long id) {
        final var user = findUserService.findById(id).orElseThrow(UserNotFoundException::new);

        if (!user.isInstructor()) {
            throw new NotInstructorException(user.getName());
        }

        final var courses = findCourseService.findAllByInstructor(user);

        return new InstructorReportDTO(
                user.getName(),
                user.getEmail(),
                courses.size(),
                courses.stream().map(CourseReportDTO::new).toList()
        );
    }
}
