package com.groboot.mdaemergency.models;

import java.util.List;

/* loaded from: classes.dex */
public class Metric {
    private int BloodDiastolic;
    private int BloodSystolic;
    private List<ExaminationResult> ExaminationResults;
    private String description;

    public int getBloodDiastolic() {
        return this.BloodDiastolic;
    }

    public int getBloodSystolic() {
        return this.BloodSystolic;
    }

    public String getDescription() {
        return this.description;
    }

    public List<ExaminationResult> getExaminationResults() {
        return this.ExaminationResults;
    }

    public void setBloodDiastolic(int i10) {
        this.BloodDiastolic = i10;
    }

    public void setBloodSystolic(int i10) {
        this.BloodSystolic = i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExaminationResults(List<ExaminationResult> list) {
        this.ExaminationResults = list;
    }
}
