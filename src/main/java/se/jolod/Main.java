package se.jolod;

import java.util.List;

public class Main {
    public static void main() {
        List<Question> questions = List.of(
                new Question.TrueOrFalse("Is this video useful?"),
                new Question.MultipleChoice("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                new Question.Text("Describe your favorite JS feature."));

        printQuiz(questions);
    }

    public static void printQuiz(List<Question> questions) {
        for (var question : questions) {
            System.out.println(question.description());
            switch (question) {
                case Question.TrueOrFalse _ -> {
                    System.out.println("1. True");
                    System.out.println("2. False");
                }
                case Question.MultipleChoice multipleChoiceQuestion -> {
                    var options = multipleChoiceQuestion.options();
                    for (int i = 0; i < options.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, options.get(i));
                    }
                }
                case Question.Text _ -> System.out.println("Answer: ___________________");
            }
            System.out.println();
        }
    }
}
