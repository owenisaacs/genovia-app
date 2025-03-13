package org.example.genoviaapp.service;

import org.example.genoviaapp.model.QuestionModel;

import java.util.List;

public class QuestionGenerationService {


    public List<QuestionModel> generateQuestions() {
        return List.of(
                new QuestionModel("Are you feeling symptoms?", false, 10),
                new QuestionModel("Have you been prescribed by a GP?", true, 0),
                new QuestionModel("Have you ordered with Genovia Helios X before?", false, 12)
        );
    }
}
