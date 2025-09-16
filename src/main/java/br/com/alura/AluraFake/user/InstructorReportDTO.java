package br.com.alura.AluraFake.user;

import br.com.alura.AluraFake.course.CourseReportDTO;

import java.util.List;

public record InstructorReportDTO(
        String name,
        String email,
        int publishedCoursesQuantity,
        List<CourseReportDTO> courses
) {
}
