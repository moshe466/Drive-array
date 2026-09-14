package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdhf implements Executor {
    boolean a = true;
    private final /* synthetic */ Executor zzgxc;
    private final /* synthetic */ zzdfs zzgxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhf(Executor executor, zzdfs zzdfsVar) {
        this.zzgxc = executor;
        this.zzgxd = zzdfsVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zzgxc.execute(new zzdhi(this, runnable));
        } catch (RejectedExecutionException e) {
            if (this.a) {
                this.zzgxd.setException(e);
            }
        }
    }
}
