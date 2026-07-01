package se.jolod;

import java.util.List;

public class Main {
    public static void main() {
        List<Question> questions = List.of(
                Question.trueOrFalse("Is this video useful?"),
                new Question.SingleChoice("What is your favorite language?",
                        List.of("CSS", "HTML", "JS", "Python")),
                new Question.MultipleChoice("Which languages do you speak?",
                        List.of("Java", "English", "Swedish")),
                new Question.Text("Describe your favorite JS feature."));

        var allTheLines = AsciiRenderer.renderQuiz(questions);

        var out = System.out;
        for (var line : allTheLines) {
            out.println(line);
        }
    }
}
