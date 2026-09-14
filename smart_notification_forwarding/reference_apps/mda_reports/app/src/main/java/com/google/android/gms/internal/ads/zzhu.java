package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhu implements Runnable {
    private final /* synthetic */ zzhr zzahf;
    private final /* synthetic */ zzit zzahl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhu(zzhr zzhrVar, zzit zzitVar) {
        this.zzahf = zzhrVar;
        this.zzahl = zzitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        this.zzahl.zzge();
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zzb(this.zzahl);
    }
}
