package br.com.alura.AluraFake.task;

public class TaskValidationException extends RuntimeException {

    private String field;

    public TaskValidationException() {
    }

    public TaskValidationException(String message) {
        super(message);
        this.field = "unknown";
    }

    public TaskValidationException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
