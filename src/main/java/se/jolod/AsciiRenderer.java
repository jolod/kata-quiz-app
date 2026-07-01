package se.jolod;

import java.util.ArrayList;
import java.util.List;

public class AsciiRenderer {

    public static ArrayList<String> renderQuiz(List<Question> questions) {
        var allTheLines = new ArrayList<String>();

        var questionNumber = 1;
        for (var question : questions) {
            var lines = renderQuestionBody(question);
            var indentedLines = lines.stream().map(line -> "   " + line).toList();
            var prefix = "%d. ". formatted(questionNumber);
            var description = question.description();
            var desc = prefix + description;

            questionNumber++;

            allTheLines.add(desc);
            allTheLines.addAll(indentedLines);
            allTheLines.add("");
        }
        return allTheLines;
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
