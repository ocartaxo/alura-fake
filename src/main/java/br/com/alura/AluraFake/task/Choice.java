package br.com.alura.AluraFake.task;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "choice_option")
    private String option;

    @Column(name = "is_correct")
    private boolean isCorrect;

    private LocalDateTime createdAt =  LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    public Choice() {
    }

    public Choice(String option, boolean isCorrect) {
        this.option = option;
        this.isCorrect = isCorrect;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
