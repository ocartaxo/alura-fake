package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Service;

@Service
public class FindCourseService {

    private final CourseRepository courseRepository;

    public FindCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Status findCourseStatusById(Long id) {
        return courseRepository.findStatusById(id);
    }
}
