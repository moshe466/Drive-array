package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzg implements zzad {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzg() {
        this(2500, 1, 1.0f);
    }

    private zzg(int i, int i2, float f) {
        this.zzr = 2500;
        this.zzt = 1;
        this.zzu = 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzad
    public final int zza() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzad
    public final void zza(zzae zzaeVar) {
        this.zzs++;
        int i = this.zzr;
        this.zzr = i + ((int) (i * this.zzu));
        if (!(this.zzs <= this.zzt)) {
            throw zzaeVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzad
    public final int zzb() {
        return this.zzs;
    }
}
