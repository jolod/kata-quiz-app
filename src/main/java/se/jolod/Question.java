package se.jolod;

import java.util.ArrayList;
import java.util.List;

public record Question(String description, List<String> lines) {
    public static Question trueOrFalse(String description) {
        return new Question(description, renderOptions(List.of("True", "False")));
    }

    public static Question multipleChoice(String description, List<String> options) {
        return new Question(description, renderOptions(options));
    }

    public static Question freeText(String description) {
        return new Question(description, List.of("Answer: ___________________"));
    }

    private static ArrayList<String> renderOptions(List<String> options) {
        var lines = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
            lines.add("%d. %s".formatted(i + 1, options.get(i)));
        }
        return lines;
    }
}
