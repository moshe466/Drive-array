package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdos {
    private final zzdpj zzhfs;
    private final zzdpj zzhft;

    public zzdos(byte[] bArr, byte[] bArr2) {
        this.zzhfs = zzdpj.zzs(bArr);
        this.zzhft = zzdpj.zzs(bArr2);
    }

    public final byte[] zzaxd() {
        zzdpj zzdpjVar = this.zzhfs;
        if (zzdpjVar == null) {
            return null;
        }
        return zzdpjVar.getBytes();
    }

    public final byte[] zzaxe() {
        zzdpj zzdpjVar = this.zzhft;
        if (zzdpjVar == null) {
            return null;
        }
        return zzdpjVar.getBytes();
    }
}
