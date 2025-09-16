package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCourseService {

    private final CourseRepository courseRepository;

    public FindCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Status findCourseStatusById(Long id) {
        return courseRepository.findCourseStatusById(id);
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
