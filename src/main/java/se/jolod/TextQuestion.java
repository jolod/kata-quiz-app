package se.jolod;

public class TextQuestion extends Question {
    TextQuestion(String description) {
        super(description);
    }

    @Override
    public void render(QuestionRenderer renderer) {
        renderer.renderTextQuestion(this);
    }
}
