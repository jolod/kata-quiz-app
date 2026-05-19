package se.jolod;

import java.util.List;

public class Main {
    public static void main() {
        var questions = List.of(
                Question.trueOrFalse("Is this video useful?"),
                Question.multipleChoice("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                Question.freeText("Describe your favorite JS feature."));

        printQuiz(questions);
    }

    public static void printQuiz(List<Question> questions) {
        for (var question : questions) {
            System.out.println(question.description());
            question.lines().forEach(System.out::println);
            System.out.println();
        }
    }
}
