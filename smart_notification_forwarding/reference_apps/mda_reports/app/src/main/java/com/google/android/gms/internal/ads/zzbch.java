package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbch extends zzbc {
    static final zzbch a = new zzbch();

    zzbch() {
    }

    @Override // com.google.android.gms.internal.ads.zzbc
    public final zzbf zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzbh() : "mvhd".equals(str) ? new zzbk() : new zzbj(str);
    }
}
