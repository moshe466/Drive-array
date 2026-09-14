package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzki implements zzkg {
    private final zzoj zzaul;
    private final int zzavf;
    private final int zzavj;

    public zzki(zzkb zzkbVar) {
        this.zzaul = zzkbVar.zzaul;
        this.zzaul.zzbe(12);
        this.zzavj = this.zzaul.zzis();
        this.zzavf = this.zzaul.zzis();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zzgq() {
        return this.zzavf;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zzgr() {
        int i = this.zzavj;
        return i == 0 ? this.zzaul.zzis() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final boolean zzgs() {
        return this.zzavj != 0;
    }
}
