package se.jolod;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    public final List<String> options;

    MultipleChoiceQuestion(String description, List<String> options) {
        super(description);

        this.options = options;
    }

    @Override
    public void printQuestionChoices() {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i));
        }
    }
}
