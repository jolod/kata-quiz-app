package se.jolod;

import java.io.PrintStream;

public abstract class Question {
    public final String description;

    Question(String description) {
        this.description = description;
    }

    public abstract void printQuestionChoices(PrintStream out);
}
