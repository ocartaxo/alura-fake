package br.com.alura.AluraFake.task;

public enum Type {
    OPEN_TEXT(Constants.OPEN_TEXT),
    MULTIPLE_CHOICE(Constants.MULTIPLE_CHOICE),
    SINGLE_CHOICE(Constants.SINGLE_CHOICE);

    public String value;

    Type(String value) {
        this.value = value;
    };

    public static class Constants {
        public static final String OPEN_TEXT = "OPEN_TEXT";
        public static final String MULTIPLE_CHOICE = "MULTIPLE_CHOICE";
        public static final String SINGLE_CHOICE = "SINGLE_CHOICE";
    }
}
