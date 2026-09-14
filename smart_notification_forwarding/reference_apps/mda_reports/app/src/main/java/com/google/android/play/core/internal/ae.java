package com.google.android.play.core.internal;

import android.util.Log;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements Runnable {
    private final /* synthetic */ List a;
    private final /* synthetic */ com.google.android.play.core.splitinstall.d b;
    private final /* synthetic */ ac c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, List list, com.google.android.play.core.splitinstall.d dVar) {
        this.c = acVar;
        this.a = list;
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ba baVar;
        try {
            baVar = this.c.c;
            if (baVar.a(this.a)) {
                this.c.a(this.b);
            } else {
                this.c.c(this.a, this.b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.b.a(-11);
        }
    }
}
