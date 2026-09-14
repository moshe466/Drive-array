package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhs implements Runnable {
    private final /* synthetic */ zzhr zzahf;
    private final /* synthetic */ zzgw zzahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhs(zzhr zzhrVar, zzgw zzgwVar) {
        this.zzahf = zzhrVar;
        this.zzahh = zzgwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho zzhoVar;
        zzhoVar = this.zzahf.zzahg;
        zzhoVar.zzb(this.zzahh);
    }
}
