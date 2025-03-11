package org.example.genoviaapp.controller;

import org.example.genoviaapp.model.AnswerModel;
import org.example.genoviaapp.model.PrescriptionDecisionModel;
import org.example.genoviaapp.model.QuestionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultations")
public class ConsultationController {

    @GetMapping("/questions")
    public QuestionModel getQuestions() {
        String[] questions = {"Are you feeling symptoms?", "Do you want a prescription?"};
        return new QuestionModel(questions);
    }

    @PostMapping("/answers")
    public PrescriptionDecisionModel postAnswer(@RequestBody List<AnswerModel> answers) {
        boolean decision = answers.stream().allMatch(answer -> answer.getAnswer().equalsIgnoreCase("yes"));
        return new PrescriptionDecisionModel(decision);
    }
}
