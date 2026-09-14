package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements Runnable {
    private final /* synthetic */ Set a;
    private final /* synthetic */ SplitCompat b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SplitCompat splitCompat, Set set) {
        this.b = splitCompat;
        this.a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        try {
            for (String str : this.a) {
                cVar = this.b.b;
                cVar.f(str);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
