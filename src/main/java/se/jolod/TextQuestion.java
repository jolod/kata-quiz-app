package se.jolod;

public class TextQuestion extends Question {
    TextQuestion(String description) {
        super(description);
    }

    @Override
    public void printQuestionChoices() {
        System.out.println("Answer: ___________________");
    }
}
