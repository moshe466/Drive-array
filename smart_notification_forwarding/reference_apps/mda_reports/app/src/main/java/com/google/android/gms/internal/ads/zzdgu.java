package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdgu<V> implements Runnable {
    private final Future<V> zzgwu;
    private final zzdgt<? super V> zzgwv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgu(Future<V> future, zzdgt<? super V> zzdgtVar) {
        this.zzgwu = future;
        this.zzgwv = zzdgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzgwv.onSuccess(zzdgs.zzb(this.zzgwu));
        } catch (Error e) {
            e = e;
            this.zzgwv.zzb(e);
        } catch (RuntimeException e2) {
            e = e2;
            this.zzgwv.zzb(e);
        } catch (ExecutionException e3) {
            this.zzgwv.zzb(e3.getCause());
        }
    }

    public final String toString() {
        return zzdec.zzz(this).zzaa(this.zzgwv).toString();
    }
}
