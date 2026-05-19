package se.jolod;

public class BooleanQuestion extends Question {
    BooleanQuestion(String description) {
        super(description);
    }

    @Override
    public void printQuestionChoices() {
        System.out.println("1. True");
        System.out.println("2. False");
    }
}
