package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c.status FROM Course c where c.id = :id")
    Status findCourseStatusById(Long id);

    List<Course> findAllByInstructor(User user);
}
