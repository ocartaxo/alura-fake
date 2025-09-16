package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCourseUseCase {

    private final FindCourseService findCourseService;

    public FindAllCourseUseCase(FindCourseService findCourseService) {
        this.findCourseService = findCourseService;
    }

    List<CourseListItemDTO> execute() {
            return findCourseService.findAllCourses().stream().map(CourseListItemDTO::new).toList();
    }
}
