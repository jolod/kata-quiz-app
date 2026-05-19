package se.jolod;

import java.util.List;

public class Main {
    public static void main() {
        var questions = List.of(
                new BooleanQuestion("Is this video useful?"),
                new MultipleChoiceQuestion("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                new TextQuestion("Describe your favorite JS feature."));

        printQuiz(questions);
    }

    public static void printQuiz(List<Question> questions) {
        for (var question : questions) {
            System.out.println(question.description);
            question.printQuestionChoices();
            System.out.println();
        }
    }
}
