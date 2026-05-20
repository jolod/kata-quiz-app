package se.jolod;

public class BooleanQuestion extends Question {
    BooleanQuestion(String description) {
        super(description);
    }

    @Override
    public void render(QuestionRenderer renderer) {
        renderer.renderBooleanQuestion(this);
    }
}
