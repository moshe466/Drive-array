package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;

/* loaded from: classes.dex */
public interface ASR {

    /* loaded from: classes.dex */
    public enum Status {
        LOCALE_DETECTING,
        LOCALE_DETECTED,
        LOCALE_DETECT_FAILED
    }

    void addAudio(byte[] bArr, double d, int i, int i2, boolean z, boolean z2) throws Exception;

    void delete() throws Exception;

    double getBufferLatency() throws Exception;

    int getChannelCount() throws Exception;

    int getFrameCount() throws Exception;

    String getLocale() throws Exception;

    double getSampleRate() throws Exception;

    Status getStatus() throws Exception;

    void init(Context context, ASRClient aSRClient, String[] strArr) throws Exception;
}
