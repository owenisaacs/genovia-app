package org.example.genoviaapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerModel {
    QuestionModel question;
    String response;

    public AnswerModel(QuestionModel question, String response) {
        this.question = question;
        this.response = response;
    }

}
