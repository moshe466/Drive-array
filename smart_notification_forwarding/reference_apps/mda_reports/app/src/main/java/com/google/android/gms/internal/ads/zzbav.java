package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes.dex */
final class zzbav implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbav(zzbas zzbasVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
