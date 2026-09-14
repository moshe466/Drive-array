package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzdvt {
    protected volatile int a = -1;

    public static final byte[] zza(zzdvt zzdvtVar) {
        byte[] bArr = new byte[zzdvtVar.zzazu()];
        try {
            zzdvo zzq = zzdvo.zzq(bArr, 0, bArr.length);
            zzdvtVar.zza(zzq);
            zzq.zzazd();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    protected int a() {
        return 0;
    }

    public String toString() {
        return zzdvw.zzb(this);
    }

    public void zza(zzdvo zzdvoVar) {
    }

    public final int zzazu() {
        int a = a();
        this.a = a;
        return a;
    }

    @Override // 
    /* renamed from: zzbcr, reason: merged with bridge method [inline-methods] */
    public zzdvt clone() {
        return (zzdvt) super.clone();
    }
}
