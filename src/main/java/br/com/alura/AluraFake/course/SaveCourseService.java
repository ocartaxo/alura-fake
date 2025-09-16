package br.com.alura.AluraFake.course;

import org.springframework.stereotype.Service;

@Service
public class SaveCourseService {
    private final  CourseRepository courseRepository;
    public SaveCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


}
