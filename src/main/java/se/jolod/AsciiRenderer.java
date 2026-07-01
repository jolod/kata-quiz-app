package se.jolod;

import java.util.ArrayList;
import java.util.List;

public class AsciiRenderer {

    public static ArrayList<String> renderQuiz(List<Question> questions) {
        var allTheLines = new ArrayList<String>();

        var questionNumber = 1;
        for (var question : questions) {
            var lines = renderQuestion(question, questionNumber);
            allTheLines.addAll(lines);
            questionNumber++;
        }
        return allTheLines;
    }

    private static ArrayList<String> renderQuestion(
            Question question,
            int questionNumber) {
        var pageWidth = 25;

        var prefix = "%d. ".formatted(questionNumber);
        var indentation = " ".repeat(prefix.length());

        var description = question.description();
        var indentationSize = indentation.length();
        var bodyLines = renderQuestionBody(question, pageWidth - indentationSize, "  ");
        var indentedLines = bodyLines.stream().map(line -> indentation + line).toList();
        var desc = prefix + description;

        var lines = new ArrayList<String>();
        lines.add(desc);
        lines.addAll(indentedLines);
        lines.add("");
        return lines;
    }

    private static List<String> renderQuestionBody(
            Question question,
            int pageWidth,
            String separator) {

        return switch (question) {
            case Question.SingleChoice singleChoiceQuestion -> stackHorizontally(
                    renderSingleChoiceOptions(singleChoiceQuestion.options()),
                    separator,
                    pageWidth
            );
            case Question.MultipleChoice multipleChoiceQuestion -> stackHorizontally(
                    renderMultipleChoiceOptions(multipleChoiceQuestion.options()),
                    separator,
                    pageWidth

            );
            case Question.Text _ -> List.of("Answer: ___________________");
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

    static List<String> stackHorizontally(
            List<String> items,
            String separator,
            int maxLength) {

        var lines = new ArrayList<String>();

        var line = new StringBuilder();
        for (var item : items) {
            if (line.isEmpty()) {
                line.append(item);
            } else {
                if (line.length() + separator.length() + item.length() <= maxLength) {
                    line.append(separator);
                    line.append(item);
                } else {
                    lines.add(line.toString());
                    line = new StringBuilder(item);
                }
            }
        }
        if (!line.isEmpty()) {
            lines.add(line.toString());
        }

        return lines;
    }
}
