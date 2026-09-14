package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m2 extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(j2 j2Var, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        t2.g();
    }
}
