package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzht implements Runnable {
    private final /* synthetic */ zzhr zzahf;
    private final /* synthetic */ String zzahi;
    private final /* synthetic */ long zzahj;
    private final /* synthetic */ long zzahk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzht(zzhr zzhrVar, String str, long j, long j2) {
        this.zzahf = zzhrVar;
        this.zzahi = str;
        this.zzahj = j;
        this.zzahk = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zza(this.zzahi, this.zzahj, this.zzahk);
    }
}
