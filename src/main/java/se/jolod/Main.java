package se.jolod;

import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main() {
        var questions = List.of(
                new BooleanQuestion("Is this video useful?"),
                new MultipleChoiceQuestion("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                new TextQuestion("Describe your favorite JS feature."));

        printQuiz(questions, System.out);
    }

    public static void printQuiz(List<Question> questions, PrintStream out) {
        for (var question : questions) {
            out.println(question.description);
            question.printQuestionChoices(out);
            out.println();
        }
    }
}
