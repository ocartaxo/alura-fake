package br.com.alura.AluraFake.task;

import java.util.List;

public final class TaskFactory {

    static NewOpenTextTaskDTO buildNewOpenTextTaskDTO() {
        return new NewOpenTextTaskDTO(
                1,
                12L,
                "O que é teste unitário?"
        );
    }

    static NewSingleChoiceTaskDTO buildNewSingleChoiceTaskDTO() {
        return new NewSingleChoiceTaskDTO(
                1,
                12L,
                "Qual palavra reservada é utilizada no Java para instanciar um objeto?",
                List.of(
                        new ChoiceDTO("build", false),
                        new ChoiceDTO("create", false),
                        new ChoiceDTO("new", true),
                        new ChoiceDTO("construct", false)
                )
        );
    }

    static NewMultipleChoicesTaskDTO buildNewMultipleChoicesTaskDTO() {
        return new NewMultipleChoicesTaskDTO(
                1,
                12L,
                "Quais linguagens são orientadas a objetos?",
                List.of(
                        new ChoiceDTO("Java", true),
                        new ChoiceDTO("C++", true),
                        new ChoiceDTO("Go", false),
                        new ChoiceDTO("Rust", false)
                )
        );
    }
}
