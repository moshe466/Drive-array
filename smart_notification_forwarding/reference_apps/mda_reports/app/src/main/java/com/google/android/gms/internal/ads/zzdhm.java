package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfs;

/* loaded from: classes.dex */
final class zzdhm extends zzdfs.zzj<Void> implements Runnable {
    private final Runnable zzgxj;

    public zzdhm(Runnable runnable) {
        this.zzgxj = (Runnable) zzdei.checkNotNull(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzgxj.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdem.zzh(th);
        }
    }
}
