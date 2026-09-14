package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhx implements Runnable {
    private final /* synthetic */ zzhr zzahf;
    private final /* synthetic */ int zzajr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(zzhr zzhrVar, int i) {
        this.zzahf = zzhrVar;
        this.zzajr = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zzr(this.zzajr);
    }
}
