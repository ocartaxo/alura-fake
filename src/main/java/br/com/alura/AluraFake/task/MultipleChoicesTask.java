package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(Type.Constants.MULTIPLE_CHOICE)
public class MultipleChoicesTask extends Task {

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();

    public MultipleChoicesTask() {
    }

    public MultipleChoicesTask(String statement, int order, Course course, List<Choice> choices) {
        super(statement, order, course);
        this.choices = choices;
    }
}

