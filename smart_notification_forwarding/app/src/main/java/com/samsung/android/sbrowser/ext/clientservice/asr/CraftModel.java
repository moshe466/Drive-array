package com.samsung.android.sbrowser.ext.clientservice.asr;

import org.vosk.Model;

/* compiled from: CraftASR.java */
/* loaded from: classes.dex */
class CraftModel {
    String mLangCode;
    Model mModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CraftModel(String str, String str2) {
        this.mModel = new Model(str);
        this.mLangCode = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Model getModel() {
        return this.mModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void delete() {
        this.mModel.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLangCode() {
        return this.mLangCode;
    }
}
