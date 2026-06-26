package se.jolod;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main() {
        var questions = List.of(
                new BooleanQuestion("Is this video useful?"),
                new MultipleChoiceQuestion("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                new TextQuestion("Describe your favorite JS feature."));

        var out = System.out;
        printQuiz(questions, out);
    }

    private static void printQuiz(List<Question> questions, PrintStream out) {
        for (var question : questions) {
            out.println(question.description);

            var lines = renderQuestionAnswerThing(question);

            for (var line : lines) {
                out.println(line);
            }

            out.println();
        }
    }

    private static List<String> renderQuestionAnswerThing(Question question) {
        return switch (question) {
            case BooleanQuestion _ -> renderOptions(List.of("True", "False"));
            case MultipleChoiceQuestion multipleChoiceQuestion -> renderOptions(multipleChoiceQuestion.options);
            case TextQuestion _ -> List.of("Answer: ___________________");
            default -> throw new RuntimeException();
        };
    }

    private static List<String> renderOptions(List<String> options) {
        var lines = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
            var optionNumber = i + 1;
            var optionText = options.get(i);

            var formatted = "%d. %s".formatted(optionNumber, optionText);

            lines.add(formatted);
        }
        return lines;
    }
}
