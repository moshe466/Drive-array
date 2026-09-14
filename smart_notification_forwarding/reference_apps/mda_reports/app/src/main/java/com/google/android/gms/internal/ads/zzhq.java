package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhq implements Runnable {
    private final /* synthetic */ zzit zzahe;
    private final /* synthetic */ zzhr zzahf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhq(zzhr zzhrVar, zzit zzitVar) {
        this.zzahf = zzhrVar;
        this.zzahe = zzitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zza(this.zzahe);
    }
}
