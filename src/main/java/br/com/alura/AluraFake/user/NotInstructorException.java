package br.com.alura.AluraFake.user;

public class NotInstructorException extends RuntimeException {

    private String field;

    private static final String DEFAULT_MESSAGE = "User %s is not instructor";

    public NotInstructorException(){}

    public NotInstructorException(String message){
        super(DEFAULT_MESSAGE.formatted(message));
        this.field = "unknown";
    }

    public String getField() {
        return field;
    }
}
