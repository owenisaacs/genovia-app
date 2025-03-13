package org.example.genoviaapp.service;

import org.example.genoviaapp.model.AnswerModel;
import org.example.genoviaapp.model.Likeliness;
import org.example.genoviaapp.model.PrescriptionDecisionModel;

import java.util.List;

public class PrescriptionDecisionService {

    private final int mediumLikelinessThreshold = 10;
    private final int highLikelinessThreshold = 20;

    public PrescriptionDecisionModel getDecision(List<AnswerModel> answers) {
        for (AnswerModel answer : answers) {
            if (answer.getQuestion().isMandatory() && answer.getResponse().equalsIgnoreCase("no")) {
                return new PrescriptionDecisionModel(false, Likeliness.NONE);
            }
        }
        int sum = answers.stream().filter(answer -> answer.getResponse().equalsIgnoreCase("yes")).mapToInt(answer -> answer.getQuestion().getScore()).sum();
        if (sum >= highLikelinessThreshold) {
            return new PrescriptionDecisionModel(true, Likeliness.HIGH);
        } else if (sum >= mediumLikelinessThreshold) {
            return new PrescriptionDecisionModel(true, Likeliness.MEDIUM);
        }
        return new PrescriptionDecisionModel(true, Likeliness.LOW);
    }
}
