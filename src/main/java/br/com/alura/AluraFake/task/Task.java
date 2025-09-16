package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "task_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statement;

    @Column(name = "task_order")
    private int order;

    private final LocalDateTime createdAt =  LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false, insertable = false, updatable = false)
    private Type taskType;

    public Task() {
    }

    public Task(String statement, int order, Course course) {
        this.statement = statement;
        this.order = order;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getStatement() {
        return statement;
    }

    public int getOrder() {
        return order;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public Type getTaskType() {
        return taskType;
    }

    public void addToCourse(Course course) {
        this.course = course;
        course.addTask(this);
    }
}
