package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes.dex */
public final class zzlx implements zzmb, zzme {
    private final Uri uri;
    private final zzddu zzact;
    private zzhg zzade;
    private final int zzazs;
    private final zzma zzazt;
    private zzme zzazu;
    private final zzno zzbbc;
    private final zzji zzbbd;
    private final int zzbbe;
    private boolean zzbbf;
    private final String zzazw = null;
    private final zzhi zzacx = new zzhi();

    public zzlx(Uri uri, zzno zznoVar, zzji zzjiVar, int i, zzddu zzdduVar, zzma zzmaVar, String str, int i2) {
        this.uri = uri;
        this.zzbbc = zznoVar;
        this.zzbbd = zzjiVar;
        this.zzazs = i;
        this.zzact = zzdduVar;
        this.zzazt = zzmaVar;
        this.zzbbe = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzlz zza(int i, zznj zznjVar) {
        zzoc.checkArgument(i == 0);
        return new zzlp(this.uri, this.zzbbc.zzih(), this.zzbbd.zzgl(), this.zzazs, this.zzact, this.zzazt, this, zznjVar, null, this.zzbbe);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zza(zzgk zzgkVar, boolean z, zzme zzmeVar) {
        this.zzazu = zzmeVar;
        this.zzade = new zzmp(-9223372036854775807L, false);
        zzmeVar.zzb(this.zzade, null);
    }

    @Override // com.google.android.gms.internal.ads.zzme
    public final void zzb(zzhg zzhgVar, Object obj) {
        boolean z = zzhgVar.zza(0, this.zzacx, false).zzagj != -9223372036854775807L;
        if (!this.zzbbf || z) {
            this.zzade = zzhgVar;
            this.zzbbf = z;
            this.zzazu.zzb(this.zzade, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzb(zzlz zzlzVar) {
        ((zzlp) zzlzVar).release();
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzhr() {
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzhs() {
        this.zzazu = null;
    }
}
