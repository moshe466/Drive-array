package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class zznw {
    private final ExecutorService zzbfp;
    private zzny<? extends zznx> zzbfq;
    private IOException zzbfr;

    public zznw(String str) {
        this.zzbfp = zzoq.zzbk(str);
    }

    public final boolean isLoading() {
        return this.zzbfq != null;
    }

    public final <T extends zznx> long zza(T t, zznv<T> zznvVar, int i) {
        Looper myLooper = Looper.myLooper();
        zzoc.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzny(this, myLooper, t, zznvVar, i, elapsedRealtime).zzek(0L);
        return elapsedRealtime;
    }

    public final void zza(Runnable runnable) {
        zzny<? extends zznx> zznyVar = this.zzbfq;
        if (zznyVar != null) {
            zznyVar.zzl(true);
        }
        this.zzbfp.execute(runnable);
        this.zzbfp.shutdown();
    }

    public final void zzbc(int i) {
        IOException iOException = this.zzbfr;
        if (iOException != null) {
            throw iOException;
        }
        zzny<? extends zznx> zznyVar = this.zzbfq;
        if (zznyVar != null) {
            zznyVar.zzbc(zznyVar.zzbfu);
        }
    }

    public final void zzil() {
        this.zzbfq.zzl(false);
    }
}
