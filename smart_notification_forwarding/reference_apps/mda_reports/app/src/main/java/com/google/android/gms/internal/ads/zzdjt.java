package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzdjt implements zzdhx {
    private static final byte[] zzgzh = new byte[0];
    private final zzdng zzgzi;
    private final zzdhx zzgzj;

    public zzdjt(zzdng zzdngVar, zzdhx zzdhxVar) {
        this.zzgzi = zzdngVar;
        this.zzgzj = zzdhxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhx
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = zzdit.zzb(this.zzgzi).toByteArray();
        byte[] zzc = this.zzgzj.zzc(byteArray, zzgzh);
        byte[] zzc2 = ((zzdhx) zzdit.zza(this.zzgzi.zzavi(), byteArray, zzdhx.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
