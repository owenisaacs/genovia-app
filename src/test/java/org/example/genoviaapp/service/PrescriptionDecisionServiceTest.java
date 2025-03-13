package org.example.genoviaapp.service;

import org.example.genoviaapp.model.AnswerModel;
import org.example.genoviaapp.model.Likeliness;
import org.example.genoviaapp.model.PrescriptionDecisionModel;
import org.example.genoviaapp.model.QuestionModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrescriptionDecisionServiceTest {
    private final PrescriptionDecisionService prescriptionDecisionService = new PrescriptionDecisionService();
    private final QuestionGenerationService questionGenerationService = new QuestionGenerationService();

    @Test
    void testGetDecisionWhenMandatoryQuestionAnswerIsNo() {
        List<QuestionModel> questions = questionGenerationService.generateQuestions();

        AnswerModel answer1 = new AnswerModel(questions.get(0), "yes");
        AnswerModel answer2 = new AnswerModel(questions.get(1), "no");
        AnswerModel answer3 = new AnswerModel(questions.get(2), "no");

        List<AnswerModel> answers = List.of(answer1, answer2, answer3);

        PrescriptionDecisionModel response = prescriptionDecisionService.getDecision(answers);

        assertFalse(response.isPrescriptionDecision());
        assertEquals(Likeliness.NONE, response.getLikeliness());
    }


    @Test
    void testGetDecisionWhenScoreIsLowThreshold() {
        List<QuestionModel> questions = questionGenerationService.generateQuestions();

        AnswerModel answer1 = new AnswerModel(questions.get(0), "no");
        AnswerModel answer2 = new AnswerModel(questions.get(1), "yes");
        AnswerModel answer3 = new AnswerModel(questions.get(2), "no");

        List<AnswerModel> answers = List.of(answer1, answer2, answer3);

        PrescriptionDecisionModel response = prescriptionDecisionService.getDecision(answers);

        assert(response.isPrescriptionDecision());
        assertEquals(Likeliness.LOW, response.getLikeliness());
    }


    @Test
    void testGetDecisionWhenScoreIsMediumThreshold() {
        List<QuestionModel> questions = questionGenerationService.generateQuestions();

        AnswerModel answer1 = new AnswerModel(questions.get(0), "yes");
        AnswerModel answer2 = new AnswerModel(questions.get(1), "yes");
        AnswerModel answer3 = new AnswerModel(questions.get(2), "No");

        List<AnswerModel> answers = List.of(answer1, answer2, answer3);

        PrescriptionDecisionModel response = prescriptionDecisionService.getDecision(answers);

        assert(response.isPrescriptionDecision());
        assertEquals(Likeliness.MEDIUM, response.getLikeliness());
    }

    @Test
    void testGetDecisionWhenScoreIsHighThreshold() {
        List<QuestionModel> questions = questionGenerationService.generateQuestions();
        AnswerModel answer1 = new AnswerModel(questions.get(0), "yes");
        AnswerModel answer2 = new AnswerModel(questions.get(1), "yes");
        AnswerModel answer3 = new AnswerModel(questions.get(2), "yes");
        List<AnswerModel> answers = List.of(answer1, answer2, answer3);

        PrescriptionDecisionModel response = prescriptionDecisionService.getDecision(answers);

        assert(response.isPrescriptionDecision());
        assertEquals(Likeliness.HIGH, response.getLikeliness());
    }

}
