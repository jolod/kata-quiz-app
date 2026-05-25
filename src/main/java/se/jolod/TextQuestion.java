package se.jolod;

import java.io.PrintStream;

public class TextQuestion extends Question {
    TextQuestion(String description) {
        super(description);
    }

    @Override
    public void printQuestionChoices(PrintStream out) {
        out.println("Answer: ___________________");
    }
}
