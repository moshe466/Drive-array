package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RenewableTimer {
    private CountDownTimer mCountDownTimer;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public RenewableTimer() {
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }

    public void start(final Callback callback, long j, long j2) {
        this.mCountDownTimer = new CountDownTimer(this, j, j2) { // from class: com.google.firebase.inappmessaging.display.internal.RenewableTimer.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                callback.onFinish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }
        }.start();
    }
}
