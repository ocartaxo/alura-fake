package br.com.alura.AluraFake.task;

public class TaskValidationException extends RuntimeException {

    public TaskValidationException() {
    }

    public TaskValidationException(String message) {
        super(message);
    }

}
