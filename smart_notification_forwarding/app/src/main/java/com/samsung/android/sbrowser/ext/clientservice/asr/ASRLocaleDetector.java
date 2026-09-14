package com.samsung.android.sbrowser.ext.clientservice.asr;

import com.samsung.android.sbrowser.ext.clientservice.asr.ASR;

/* loaded from: classes.dex */
abstract class ASRLocaleDetector {
    private ASR.Status mStatus = ASR.Status.LOCALE_DETECTING;

    public abstract boolean addAudio(byte[] bArr, int i, double d) throws Exception;

    public abstract void delete() throws Exception;

    public abstract void reset() throws Exception;

    public ASR.Status getStatus() {
        return this.mStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStatus(ASR.Status status) {
        this.mStatus = status;
    }
}
