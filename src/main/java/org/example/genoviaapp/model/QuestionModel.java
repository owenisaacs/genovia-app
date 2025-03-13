package org.example.genoviaapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionModel {
    private final String question;
    private final boolean mandatory;
    private final int score;

    public QuestionModel(String question, boolean mandatory, int score) {
        this.question = question;
        this.mandatory = mandatory;
        this.score = score;
    }
}
