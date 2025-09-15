package br.com.alura.AluraFake.task;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String option;

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

}
