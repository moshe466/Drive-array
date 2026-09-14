package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class zzdor implements zzdie {
    private static final byte[] zzgzh = new byte[0];
    private final String zzhfn;
    private final byte[] zzhfo;
    private final zzdow zzhfp;
    private final zzdop zzhfq;
    private final zzdot zzhfr;

    public zzdor(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdow zzdowVar, zzdop zzdopVar) {
        zzdov.a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzhfr = new zzdot(eCPublicKey);
        this.zzhfo = bArr;
        this.zzhfn = str;
        this.zzhfp = zzdowVar;
        this.zzhfq = zzdopVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdie
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        zzdos zza = this.zzhfr.zza(this.zzhfn, this.zzhfo, bArr2, this.zzhfq.zzasr(), this.zzhfp);
        byte[] zzc = this.zzhfq.zzm(zza.zzaxe()).zzc(bArr, zzgzh);
        byte[] zzaxd = zza.zzaxd();
        return ByteBuffer.allocate(zzaxd.length + zzc.length).put(zzaxd).put(zzc).array();
    }
}
