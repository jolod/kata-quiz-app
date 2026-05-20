package se.jolod;

import java.util.List;

public sealed interface Question {
    String description();

    record TrueOrFalse(String description) implements Question {
    }

    record MultipleChoice(String description, List<String> options) implements Question {
    }

    record Text(String description) implements Question {
    }
}
