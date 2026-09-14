package com.google.android.play.core.splitcompat;

import android.content.Context;

/* loaded from: classes.dex */
final class o implements Runnable {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.play.core.splitinstall.n.a(this.a).a(true);
    }
}
