package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.User;
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

    public List<Course> findAllByInstructor(User instructor) {
        return courseRepository.findAllByInstructor(instructor);
    }
}
