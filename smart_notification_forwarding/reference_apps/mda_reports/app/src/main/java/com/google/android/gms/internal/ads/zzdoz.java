package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzdoz implements zzdhx {
    private final zzdpi zzhgq;
    private final zzdio zzhgr;
    private final int zzhgs;

    public zzdoz(zzdpi zzdpiVar, zzdio zzdioVar, int i) {
        this.zzhgq = zzdpiVar;
        this.zzhgr = zzdioVar;
        this.zzhgs = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdhx
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] zzp = this.zzhgq.zzp(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzdoi.zza(zzp, this.zzhgr.zzl(zzdoi.zza(bArr2, zzp, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
