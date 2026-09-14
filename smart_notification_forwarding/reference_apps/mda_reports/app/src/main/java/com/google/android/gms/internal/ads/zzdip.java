package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzdip<P> {
    private final P zzgya;
    private final byte[] zzgyb;
    private final zzdne zzgyc;
    private final zzdnw zzgyd;

    public zzdip(P p, byte[] bArr, zzdne zzdneVar, zzdnw zzdnwVar) {
        this.zzgya = p;
        this.zzgyb = Arrays.copyOf(bArr, bArr.length);
        this.zzgyc = zzdneVar;
        this.zzgyd = zzdnwVar;
    }

    public final P zzasi() {
        return this.zzgya;
    }

    public final zzdne zzasj() {
        return this.zzgyc;
    }

    public final zzdnw zzask() {
        return this.zzgyd;
    }

    public final byte[] zzasl() {
        byte[] bArr = this.zzgyb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
