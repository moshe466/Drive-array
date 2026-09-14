package org.vosk.android;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import org.vosk.Recognizer;
import org.vosk.android.SpeechStreamService;

/* loaded from: classes2.dex */
public class SpeechStreamService {
    private static final float BUFFER_SIZE_SECONDS = 0.2f;
    private final int bufferSize;
    private final InputStream inputStream;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Recognizer recognizer;
    private Thread recognizerThread;
    private final int sampleRate;

    public SpeechStreamService(Recognizer recognizer, InputStream inputStream, float sampleRate) {
        this.recognizer = recognizer;
        int i = (int) sampleRate;
        this.sampleRate = i;
        this.inputStream = inputStream;
        this.bufferSize = Math.round(i * BUFFER_SIZE_SECONDS * 2.0f);
    }

    public boolean start(RecognitionListener listener) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(this, listener);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public boolean start(RecognitionListener listener, int timeout) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(listener, timeout);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public boolean stop() {
        Thread thread = this.recognizerThread;
        if (thread == null) {
            return false;
        }
        try {
            thread.interrupt();
            this.recognizerThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.recognizerThread = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class RecognizerThread extends Thread {
        private static final int NO_TIMEOUT = -1;
        RecognitionListener listener;
        private int remainingSamples;
        private final int timeoutSamples;

        public RecognizerThread(RecognitionListener listener, int timeout) {
            this.listener = listener;
            if (timeout != -1) {
                this.timeoutSamples = (timeout * SpeechStreamService.this.sampleRate) / 1000;
            } else {
                this.timeoutSamples = -1;
            }
            this.remainingSamples = this.timeoutSamples;
        }

        public RecognizerThread(final SpeechStreamService this$0, RecognitionListener listener) {
            this(listener, -1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            int i = SpeechStreamService.this.bufferSize;
            byte[] bArr = new byte[i];
            while (!interrupted() && (this.timeoutSamples == -1 || this.remainingSamples > 0)) {
                try {
                    read = SpeechStreamService.this.inputStream.read(bArr, 0, i);
                } catch (IOException e) {
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechStreamService$RecognizerThread$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            SpeechStreamService.RecognizerThread.this.m1694xd636fe48(e);
                        }
                    });
                }
                if (read < 0) {
                    break;
                }
                if (SpeechStreamService.this.recognizer.acceptWaveForm(bArr, read)) {
                    final String result = SpeechStreamService.this.recognizer.getResult();
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechStreamService$RecognizerThread$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            SpeechStreamService.RecognizerThread.this.m1692x838e53c6(result);
                        }
                    });
                } else {
                    final String partialResult = SpeechStreamService.this.recognizer.getPartialResult();
                    SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechStreamService$RecognizerThread$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            SpeechStreamService.RecognizerThread.this.m1693xace2a907(partialResult);
                        }
                    });
                }
                if (this.timeoutSamples != -1) {
                    this.remainingSamples -= read;
                }
            }
            if (this.timeoutSamples == -1 || this.remainingSamples > 0) {
                final String finalResult = SpeechStreamService.this.recognizer.getFinalResult();
                SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechStreamService$RecognizerThread$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechStreamService.RecognizerThread.this.m1696x28dfa8ca(finalResult);
                    }
                });
            } else {
                SpeechStreamService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechStreamService$RecognizerThread$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechStreamService.RecognizerThread.this.m1695xff8b5389();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$0$org-vosk-android-SpeechStreamService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1692x838e53c6(final String result) {
            this.listener.onResult(result);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$1$org-vosk-android-SpeechStreamService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1693xace2a907(final String partialResult) {
            this.listener.onPartialResult(partialResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$2$org-vosk-android-SpeechStreamService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1694xd636fe48(final IOException e) {
            this.listener.onError(e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$3$org-vosk-android-SpeechStreamService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1695xff8b5389() {
            this.listener.onTimeout();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$4$org-vosk-android-SpeechStreamService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1696x28dfa8ca(final String finalResult) {
            this.listener.onFinalResult(finalResult);
        }
    }
}
