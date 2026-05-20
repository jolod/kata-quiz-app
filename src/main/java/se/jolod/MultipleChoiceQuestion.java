package se.jolod;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    public final List<String> options;

    MultipleChoiceQuestion(String description, List<String> options) {
        super(description);

        this.options = options;
    }

    @Override
    public void render(QuestionRenderer renderer) {
        renderer.renderMultipleChoiceQuestion(this);
    }
}
