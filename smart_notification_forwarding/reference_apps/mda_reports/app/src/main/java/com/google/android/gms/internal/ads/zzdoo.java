package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class zzdoo implements zzdib {
    private static final byte[] zzgzh = new byte[0];
    private final ECPrivateKey zzhfl;
    private final zzdoq zzhfm;
    private final String zzhfn;
    private final byte[] zzhfo;
    private final zzdow zzhfp;
    private final zzdop zzhfq;

    public zzdoo(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdow zzdowVar, zzdop zzdopVar) {
        this.zzhfl = eCPrivateKey;
        this.zzhfm = new zzdoq(eCPrivateKey);
        this.zzhfo = bArr;
        this.zzhfn = str;
        this.zzhfp = zzdowVar;
        this.zzhfq = zzdopVar;
    }
}
