package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzsv {
    private final byte[] zzbua;
    private int zzbub;
    private int zzbuc;
    private final /* synthetic */ zzsr zzbud;

    private zzsv(zzsr zzsrVar, byte[] bArr) {
        this.zzbud = zzsrVar;
        this.zzbua = bArr;
    }

    public final zzsv zzbq(int i) {
        this.zzbub = i;
        return this;
    }

    public final zzsv zzbr(int i) {
        this.zzbuc = i;
        return this;
    }

    public final synchronized void zzdn() {
        try {
            if (this.zzbud.b) {
                this.zzbud.a.zzc(this.zzbua);
                this.zzbud.a.zzm(this.zzbub);
                this.zzbud.a.zzn(this.zzbuc);
                this.zzbud.a.zza(null);
                this.zzbud.a.zzdn();
            }
        } catch (RemoteException e) {
            zzayu.zzb("Clearcut log failed", e);
        }
    }
}
