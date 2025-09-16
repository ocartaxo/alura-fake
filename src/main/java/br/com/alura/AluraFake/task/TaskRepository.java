package br.com.alura.AluraFake.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByStatementIgnoringCase(String statement);

    boolean existsTaskByOrder(int order);

    @Modifying
    @Query("UPDATE Task t SET t.order = t.order + 1 WHERE t.course.id = :courseId AND t.order >= :order")
    void shiftOrdersUp(Long courseId, int order);

}
