package com.google.android.play.core.splitcompat;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Runnable {
    private final /* synthetic */ SplitCompat a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        try {
            cVar = this.a.b;
            cVar.a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
