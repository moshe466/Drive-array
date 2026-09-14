package com.groboot.mdaemergency.models;

import java.util.UUID;
import y8.k;

/* loaded from: classes.dex */
public final class SerologyQuestionnaire {
    private boolean AbdominalPain;
    private boolean BreathingDifficulties;
    private boolean Cough;
    private boolean Diarrhea;
    private boolean FeverOver38;
    private String FirstSymptomDate;
    private boolean LossOfTaste;
    private boolean MusclePain;
    private boolean OtherSymptoms;
    private UUID PatientKey;
    private boolean Shivering;
    private boolean Snot;
    private boolean SoreThroat;
    private boolean SymptomsSince022020;
    private boolean Tiredness;

    public SerologyQuestionnaire() {
        this.FirstSymptomDate = new String();
        UUID randomUUID = UUID.randomUUID();
        k.d(randomUUID, "randomUUID()");
        this.PatientKey = randomUUID;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerologyQuestionnaire(UUID uuid) {
        this();
        k.e(uuid, "_patientId");
        this.PatientKey = uuid;
    }

    public final boolean getAbdominalPain() {
        return this.AbdominalPain;
    }

    public final boolean getBreathingDifficulties() {
        return this.BreathingDifficulties;
    }

    public final boolean getCough() {
        return this.Cough;
    }

    public final boolean getDiarrhea() {
        return this.Diarrhea;
    }

    public final boolean getFeverOver38() {
        return this.FeverOver38;
    }

    public final String getFirstSymptomDate() {
        return this.FirstSymptomDate;
    }

    public final boolean getLossOfTaste() {
        return this.LossOfTaste;
    }

    public final boolean getMusclePain() {
        return this.MusclePain;
    }

    public final boolean getOtherSymptoms() {
        return this.OtherSymptoms;
    }

    public final UUID getPatientKey() {
        return this.PatientKey;
    }

    public final boolean getShivering() {
        return this.Shivering;
    }

    public final boolean getSnot() {
        return this.Snot;
    }

    public final boolean getSoreThroat() {
        return this.SoreThroat;
    }

    public final boolean getSymptomsSince022020() {
        return this.SymptomsSince022020;
    }

    public final boolean getTiredness() {
        return this.Tiredness;
    }

    public final void setAbdominalPain(boolean z10) {
        this.AbdominalPain = z10;
    }

    public final void setBreathingDifficulties(boolean z10) {
        this.BreathingDifficulties = z10;
    }

    public final void setCough(boolean z10) {
        this.Cough = z10;
    }

    public final void setDiarrhea(boolean z10) {
        this.Diarrhea = z10;
    }

    public final void setFeverOver38(boolean z10) {
        this.FeverOver38 = z10;
    }

    public final void setFirstSymptomDate(String str) {
        k.e(str, "<set-?>");
        this.FirstSymptomDate = str;
    }

    public final void setLossOfTaste(boolean z10) {
        this.LossOfTaste = z10;
    }

    public final void setMusclePain(boolean z10) {
        this.MusclePain = z10;
    }

    public final void setOtherSymptoms(boolean z10) {
        this.OtherSymptoms = z10;
    }

    public final void setPatientKey(UUID uuid) {
        k.e(uuid, "<set-?>");
        this.PatientKey = uuid;
    }

    public final void setShivering(boolean z10) {
        this.Shivering = z10;
    }

    public final void setSnot(boolean z10) {
        this.Snot = z10;
    }

    public final void setSoreThroat(boolean z10) {
        this.SoreThroat = z10;
    }

    public final void setSymptomsSince022020(boolean z10) {
        this.SymptomsSince022020 = z10;
    }

    public final void setTiredness(boolean z10) {
        this.Tiredness = z10;
    }
}
