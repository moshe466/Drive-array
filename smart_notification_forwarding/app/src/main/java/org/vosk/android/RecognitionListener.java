package org.vosk.android;

/* loaded from: classes2.dex */
public interface RecognitionListener {
    void onError(Exception exception);

    void onFinalResult(String hypothesis);

    void onPartialResult(String hypothesis);

    void onResult(String hypothesis);

    void onTimeout();
}
