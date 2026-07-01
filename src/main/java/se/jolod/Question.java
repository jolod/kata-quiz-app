package se.jolod;

import java.util.List;

public sealed interface Question {
    String description();

    static Question trueOrFalse(String description) {
        return new SingleChoice(description, List.of("True", "False"));
    }

    record SingleChoice(String description, List<String> options) implements Question {
    }

    record MultipleChoice(String description, List<String> options) implements Question {
    }

    record Text(String description) implements Question {
    }
}
