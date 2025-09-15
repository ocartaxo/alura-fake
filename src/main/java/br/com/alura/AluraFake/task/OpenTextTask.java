package br.com.alura.AluraFake.task;

import br.com.alura.AluraFake.course.Course;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(Type.Constants.OPEN_TEXT)
public class OpenTextTask extends Task {


    public OpenTextTask() {
    }

    public OpenTextTask(String statement, int order, Course course) {
        super(statement, order, course);
    }
}
