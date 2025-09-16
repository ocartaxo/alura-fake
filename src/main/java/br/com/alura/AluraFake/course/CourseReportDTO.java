package br.com.alura.AluraFake.course;

import java.time.LocalDateTime;

public record CourseReportDTO(
        Long id,
        String title,
        Status status,
        LocalDateTime publishedAt,
        int taskQuantity
) {
    public CourseReportDTO(Course course) {
        this(course.getId(), course.getTitle(), course.getStatus(), course.getPublishedAt(), course.getTasks().size());
    }
}
