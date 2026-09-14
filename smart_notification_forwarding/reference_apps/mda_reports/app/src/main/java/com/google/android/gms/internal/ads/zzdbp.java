package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdbp {
    private final zzdbo zzgpl = new zzdbo();
    private int zzgpn = 0;
    private int zzgpo = 0;
    private int zzgpj = 0;
    private final long zzgpk = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
    private long zzgpm = this.zzgpk;

    public final long getCreationTimeMillis() {
        return this.zzgpk;
    }

    public final long zzaoy() {
        return this.zzgpm;
    }

    public final int zzaoz() {
        return this.zzgpn;
    }

    public final String zzapk() {
        return "Created: " + this.zzgpk + " Last accessed: " + this.zzgpm + " Accesses: " + this.zzgpn + "\nEntries retrieved: Valid: " + this.zzgpo + " Stale: " + this.zzgpj;
    }

    public final void zzapr() {
        this.zzgpm = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
        this.zzgpn++;
    }

    public final void zzaps() {
        this.zzgpo++;
        this.zzgpl.zzgpi = true;
    }

    public final void zzapt() {
        this.zzgpj++;
        this.zzgpl.zzgpj++;
    }

    public final zzdbo zzapu() {
        zzdbo zzdboVar = (zzdbo) this.zzgpl.clone();
        zzdbo zzdboVar2 = this.zzgpl;
        zzdboVar2.zzgpi = false;
        zzdboVar2.zzgpj = 0;
        return zzdboVar;
    }
}
