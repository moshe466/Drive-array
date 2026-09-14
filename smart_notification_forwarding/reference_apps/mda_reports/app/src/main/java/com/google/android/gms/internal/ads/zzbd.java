package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* loaded from: classes.dex */
public class zzbd extends zzdwq implements Closeable {
    private static zzdwy zzcr = zzdwy.zzn(zzbd.class);

    public zzbd(zzdws zzdwsVar, zzbe zzbeVar) {
        zza(zzdwsVar, zzdwsVar.size(), zzbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdwq, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    @Override // com.google.android.gms.internal.ads.zzdwq
    public String toString() {
        String obj = this.b.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
