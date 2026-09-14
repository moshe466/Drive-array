package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

/* loaded from: classes.dex */
public class zzddu extends Handler {
    private static volatile zzddx zzgtt;

    public zzddu() {
    }

    public zzddu(Looper looper) {
        super(looper);
    }

    public zzddu(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void a(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        a(message);
    }
}
