package se.jolod;

public abstract class Question implements RenderableQuestion {
    public final String description;

    Question(String description) {
        this.description = description;
    }
}
