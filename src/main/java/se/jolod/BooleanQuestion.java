package se.jolod;

import java.io.PrintStream;

public class BooleanQuestion extends Question {
    BooleanQuestion(String description) {
        super(description);
    }

    @Override
    public void printQuestionChoices(PrintStream out) {
        out.println("1. True");
        out.println("2. False");
    }
}
