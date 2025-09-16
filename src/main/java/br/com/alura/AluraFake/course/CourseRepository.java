package br.com.alura.AluraFake.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.status FROM Course c where c.id = :id")
    Status findCourseStatusById(Long id);
}
