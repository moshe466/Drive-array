package org.vosk.android;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import org.vosk.Recognizer;
import org.vosk.android.SpeechService;

/* loaded from: classes2.dex */
public class SpeechService {
    private static final float BUFFER_SIZE_SECONDS = 0.2f;
    private final int bufferSize;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Recognizer recognizer;
    private RecognizerThread recognizerThread;
    private final AudioRecord recorder;
    private final int sampleRate;

    public SpeechService(Recognizer recognizer, float sampleRate) throws IOException {
        this.recognizer = recognizer;
        int i = (int) sampleRate;
        this.sampleRate = i;
        int round = Math.round(i * BUFFER_SIZE_SECONDS);
        this.bufferSize = round;
        AudioRecord audioRecord = new AudioRecord(6, i, 16, 2, round * 2);
        this.recorder = audioRecord;
        if (audioRecord.getState() != 0) {
            return;
        }
        audioRecord.release();
        throw new IOException("Failed to initialize recorder. Microphone might be already in use.");
    }

    public boolean startListening(RecognitionListener listener) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(this, listener);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    public boolean startListening(RecognitionListener listener, int timeout) {
        if (this.recognizerThread != null) {
            return false;
        }
        RecognizerThread recognizerThread = new RecognizerThread(listener, timeout);
        this.recognizerThread = recognizerThread;
        recognizerThread.start();
        return true;
    }

    private boolean stopRecognizerThread() {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread == null) {
            return false;
        }
        try {
            recognizerThread.interrupt();
            this.recognizerThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.recognizerThread = null;
        return true;
    }

    public boolean stop() {
        return stopRecognizerThread();
    }

    public boolean cancel() {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.setPause(true);
        }
        return stopRecognizerThread();
    }

    public void shutdown() {
        this.recorder.release();
    }

    public void setPause(boolean paused) {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.setPause(paused);
        }
    }

    public void reset() {
        RecognizerThread recognizerThread = this.recognizerThread;
        if (recognizerThread != null) {
            recognizerThread.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class RecognizerThread extends Thread {
        private static final int NO_TIMEOUT = -1;
        RecognitionListener listener;
        private volatile boolean paused;
        private int remainingSamples;
        private volatile boolean reset;
        private final int timeoutSamples;

        public RecognizerThread(RecognitionListener listener, int timeout) {
            this.paused = false;
            this.reset = false;
            this.listener = listener;
            if (timeout != -1) {
                this.timeoutSamples = (timeout * SpeechService.this.sampleRate) / 1000;
            } else {
                this.timeoutSamples = -1;
            }
            this.remainingSamples = this.timeoutSamples;
        }

        public RecognizerThread(final SpeechService this$0, RecognitionListener listener) {
            this(listener, -1);
        }

        public void setPause(boolean paused) {
            this.paused = paused;
        }

        public void reset() {
            this.reset = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SpeechService.this.recorder.startRecording();
            if (SpeechService.this.recorder.getRecordingState() == 1) {
                SpeechService.this.recorder.stop();
                final IOException iOException = new IOException("Failed to start recording. Microphone might be already in use.");
                SpeechService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechService$RecognizerThread$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechService.RecognizerThread.this.m1687lambda$run$0$orgvoskandroidSpeechService$RecognizerThread(iOException);
                    }
                });
            }
            int i = SpeechService.this.bufferSize;
            short[] sArr = new short[i];
            while (!interrupted() && (this.timeoutSamples == -1 || this.remainingSamples > 0)) {
                int read = SpeechService.this.recorder.read(sArr, 0, i);
                if (!this.paused) {
                    if (this.reset) {
                        SpeechService.this.recognizer.reset();
                        this.reset = false;
                    }
                    if (read >= 0) {
                        if (SpeechService.this.recognizer.acceptWaveForm(sArr, read)) {
                            final String result = SpeechService.this.recognizer.getResult();
                            SpeechService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechService$RecognizerThread$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SpeechService.RecognizerThread.this.m1688lambda$run$1$orgvoskandroidSpeechService$RecognizerThread(result);
                                }
                            });
                        } else {
                            final String partialResult = SpeechService.this.recognizer.getPartialResult();
                            SpeechService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechService$RecognizerThread$$ExternalSyntheticLambda2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SpeechService.RecognizerThread.this.m1689lambda$run$2$orgvoskandroidSpeechService$RecognizerThread(partialResult);
                                }
                            });
                        }
                        if (this.timeoutSamples != -1) {
                            this.remainingSamples -= read;
                        }
                    } else {
                        throw new RuntimeException("error reading audio buffer");
                    }
                }
            }
            SpeechService.this.recorder.stop();
            if (this.paused) {
                return;
            }
            if (this.timeoutSamples == -1 || this.remainingSamples > 0) {
                final String finalResult = SpeechService.this.recognizer.getFinalResult();
                SpeechService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechService$RecognizerThread$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechService.RecognizerThread.this.m1691lambda$run$4$orgvoskandroidSpeechService$RecognizerThread(finalResult);
                    }
                });
            } else {
                SpeechService.this.mainHandler.post(new Runnable() { // from class: org.vosk.android.SpeechService$RecognizerThread$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechService.RecognizerThread.this.m1690lambda$run$3$orgvoskandroidSpeechService$RecognizerThread();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$0$org-vosk-android-SpeechService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1687lambda$run$0$orgvoskandroidSpeechService$RecognizerThread(final IOException ioe) {
            this.listener.onError(ioe);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$1$org-vosk-android-SpeechService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1688lambda$run$1$orgvoskandroidSpeechService$RecognizerThread(final String result) {
            this.listener.onResult(result);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$2$org-vosk-android-SpeechService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1689lambda$run$2$orgvoskandroidSpeechService$RecognizerThread(final String partialResult) {
            this.listener.onPartialResult(partialResult);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$3$org-vosk-android-SpeechService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1690lambda$run$3$orgvoskandroidSpeechService$RecognizerThread() {
            this.listener.onTimeout();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$4$org-vosk-android-SpeechService$RecognizerThread, reason: not valid java name */
        public /* synthetic */ void m1691lambda$run$4$orgvoskandroidSpeechService$RecognizerThread(final String finalResult) {
            this.listener.onFinalResult(finalResult);
        }
    }
}
