package br.com.alura.AluraFake.user;

public class UserNotFoundException extends RuntimeException {

    private static final String DEFAULT_MSG = "User not found";
    private String field;

    public UserNotFoundException() {
        super(DEFAULT_MSG);
        this.field = "userId";
    }

    public UserNotFoundException(String message) {
        super(message);
        this.field = "userId";
    }

    public String getField() {
        return field;
    }
}
