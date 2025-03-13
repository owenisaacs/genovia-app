package org.example.genoviaapp.controller;

import org.example.genoviaapp.model.AnswerModel;
import org.example.genoviaapp.model.PrescriptionDecisionModel;
import org.example.genoviaapp.model.QuestionModel;
import org.example.genoviaapp.service.PrescriptionDecisionService;
import org.example.genoviaapp.service.QuestionGenerationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultations")
public class ConsultationController {

    final QuestionGenerationService questionGenerationService = new QuestionGenerationService();
    final PrescriptionDecisionService prescriptionDecisionService = new PrescriptionDecisionService();

    @GetMapping("/questions")
    public List<QuestionModel> getQuestions() {
        return questionGenerationService.generateQuestions();
    }

    @PostMapping("/answers")
    public PrescriptionDecisionModel postAnswer(@RequestBody List<AnswerModel> answers) {
        return prescriptionDecisionService.getDecision(answers);
    }
}
