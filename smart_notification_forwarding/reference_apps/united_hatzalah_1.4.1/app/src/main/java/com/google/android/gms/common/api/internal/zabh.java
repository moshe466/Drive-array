package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zabh implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabk zab;

    public zabh(zabk zabkVar, int i) {
        this.zaa = i;
        Objects.requireNonNull(zabkVar);
        this.zab = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zau(this.zaa);
    }
}
