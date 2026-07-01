package se.jolod;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AsciiPrinter {
    public static void printQuiz(List<Question> questions, PrintStream out) {
        var questionNumber = 1;
        for (var question : questions) {
            var prefix = "%d. ". formatted(questionNumber);
            out.print(prefix);
            out.println(question.description());

            var lines = renderQuestionBody(question);

            for (var line : lines) {
                out.println(line);
            }

            out.println();

            questionNumber++;
        }
    }

    private static List<String> renderQuestionBody(Question question) {
        return switch (question) {
            case Question.SingleChoice singleChoiceQuestion ->
                    renderSingleChoiceOptions(singleChoiceQuestion.options());
            case Question.MultipleChoice multipleChoiceQuestion ->
                    renderMultipleChoiceOptions(multipleChoiceQuestion.options());
            case Question.Text _ ->
                    List.of("Answer: ___________________");
        };
    }

    private static List<String> renderSingleChoiceOptions(List<String> options) {
        var lines = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
            var optionNumber = i + 1;
            var optionText = options.get(i);

            var formatted = "%d. %s".formatted(optionNumber, optionText);

            lines.add(formatted);
        }
        return lines;
    }

    private static List<String> renderMultipleChoiceOptions(List<String> options) {
        return options
                .stream()
                .map("[ ] %s"::formatted)
                .toList();
    }
}
