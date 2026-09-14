package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdf implements Runnable {
    private final /* synthetic */ zzdc zzva;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdf(zzdc zzdcVar) {
        this.zzva = zzdcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzva.zzbp();
    }
}
