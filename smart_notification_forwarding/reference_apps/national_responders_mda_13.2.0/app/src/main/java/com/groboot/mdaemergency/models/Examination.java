package com.groboot.mdaemergency.models;

import java.util.List;

/* loaded from: classes.dex */
public class Examination {
    private int ExaminationID;
    private String ExaminationName;
    private List<ExaminationValue> ExaminationValues;
    ExaminationValue currentValue;

    public ExaminationValue getCurrentValue() {
        return this.currentValue;
    }

    public int getExaminationID() {
        return this.ExaminationID;
    }

    public String getExaminationName() {
        return this.ExaminationName;
    }

    public List<ExaminationValue> getExaminationValues() {
        return this.ExaminationValues;
    }

    public void setCurrentValue(ExaminationValue examinationValue) {
        this.currentValue = examinationValue;
    }

    public void setExaminationID(int i10) {
        this.ExaminationID = i10;
    }

    public void setExaminationName(String str) {
        this.ExaminationName = str;
    }

    public void setExaminationValues(List<ExaminationValue> list) {
        this.ExaminationValues = list;
    }
}
