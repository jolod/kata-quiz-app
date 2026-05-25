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
            printQuestionChoices(question);
            System.out.println();
        }
    }

    private static void printQuestionChoices(Question question) {
        switch (question) {
            case BooleanQuestion _ -> printBooleanQuestionChoices();
            case MultipleChoiceQuestion multipleChoiceQuestion ->
                    printMultipleChoiceQuestionChoices(multipleChoiceQuestion);
            case TextQuestion _ -> printTextQuestionChoices();
            default -> throw new RuntimeException();
        }
    }

    private static void printBooleanQuestionChoices() {
        System.out.println("1. True");
        System.out.println("2. False");
    }

    private static void printMultipleChoiceQuestionChoices(MultipleChoiceQuestion multipleChoiceQuestion) {
        var options = multipleChoiceQuestion.options;
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i));
        }
    }

    private static void printTextQuestionChoices() {
        System.out.println("Answer: ___________________");
    }
}
