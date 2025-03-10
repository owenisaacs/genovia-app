package org.example.genoviaapp.model;

public class PrescriptionDecisionModel {
    boolean prescriptionDescision;

    public PrescriptionDecisionModel(boolean prescriptionDescision) {
        this.prescriptionDescision = prescriptionDescision;
    }

    public boolean isPrescriptionDescision() {
        return prescriptionDescision;
    }

    public void setPrescriptionDescision(boolean prescriptionDescision) {
        this.prescriptionDescision = prescriptionDescision;
    }
}
