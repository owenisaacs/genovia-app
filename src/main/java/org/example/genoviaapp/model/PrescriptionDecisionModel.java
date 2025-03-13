package org.example.genoviaapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionDecisionModel {

    boolean prescriptionDecision;
    Likeliness likeliness;

    public PrescriptionDecisionModel(boolean prescriptionDecision, Likeliness likeliness) {
        this.prescriptionDecision = prescriptionDecision;
        this.likeliness  = likeliness;
    }

}
