package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzawd implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzawb zzdsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawd(zzawb zzawbVar, Context context) {
        this.zzdsw = zzawbVar;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.zzdsw.zzdss;
        synchronized (obj) {
            this.zzdsw.zzbfb = zzawb.a(this.val$context);
            obj2 = this.zzdsw.zzdss;
            obj2.notifyAll();
        }
    }
}
