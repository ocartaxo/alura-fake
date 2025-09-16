package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.User;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseService {
    private final  CourseRepository courseRepository;

    public SaveCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(NewCourseDTO newCourse, User author) {
        Course course = new Course(newCourse.getTitle(), newCourse.getDescription(), author);
        courseRepository.save(course);
    }

}
