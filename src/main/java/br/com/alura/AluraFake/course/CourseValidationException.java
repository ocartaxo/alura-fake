package br.com.alura.AluraFake.course;

public class CourseValidationException extends RuntimeException {

    private String field;

    public CourseValidationException() {
    }

    public CourseValidationException(String message) {
        super(message);
        this.field = "unknown";
    }

    public CourseValidationException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
