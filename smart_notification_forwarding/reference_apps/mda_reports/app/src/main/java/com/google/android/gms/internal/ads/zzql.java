package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzql implements Runnable {
    private final /* synthetic */ zzqi zzbpz;
    private final /* synthetic */ View zzbqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzql(zzqi zzqiVar, View view) {
        this.zzbpz = zzqiVar;
        this.zzbqa = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbpz.a(this.zzbqa);
    }
}
