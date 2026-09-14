package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhv implements Runnable {
    private final /* synthetic */ zzhr zzahf;
    private final /* synthetic */ int zzahm;
    private final /* synthetic */ long zzahn;
    private final /* synthetic */ long zzaho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhv(zzhr zzhrVar, int i, long j, long j2) {
        this.zzahf = zzhrVar;
        this.zzahm = i;
        this.zzahn = j;
        this.zzaho = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zza(this.zzahm, this.zzahn, this.zzaho);
    }
}
