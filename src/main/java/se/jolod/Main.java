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
        var renderer = new AsciiRenderer();
        for (var question : questions) {
            System.out.println(question.description);
            question.render(renderer);
            System.out.println();
        }
    }

    private static class AsciiRenderer implements QuestionRenderer {
        @Override
        public void renderBooleanQuestion(BooleanQuestion booleanQuestion) {
            System.out.println("1. True");
            System.out.println("2. False");
        }

        @Override
        public void renderMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
            var options = multipleChoiceQuestion.options;
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, options.get(i));
            }
        }

        @Override
        public void renderTextQuestion(TextQuestion textQuestion) {
            System.out.println("Answer: ___________________");
        }
    }
}
