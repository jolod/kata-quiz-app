package se.jolod;

public interface QuestionRenderer {
    void renderBooleanQuestion(BooleanQuestion booleanQuestion);

    void renderMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion);

    void renderTextQuestion(TextQuestion textQuestion);
}
