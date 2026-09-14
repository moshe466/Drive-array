package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzdgi<T> extends zzdha<T> {
    boolean a = true;
    private final Executor zzgwn;
    private final /* synthetic */ zzdgg zzgwp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgi(zzdgg zzdggVar, Executor executor) {
        this.zzgwp = zzdggVar;
        this.zzgwn = (Executor) zzdei.checkNotNull(executor);
    }

    abstract void a(T t);

    @Override // com.google.android.gms.internal.ads.zzdha
    final void a(T t, Throwable th) {
        zzdgg.a(this.zzgwp, (zzdgi) null);
        if (th == null) {
            a(t);
            return;
        }
        if (th instanceof ExecutionException) {
            this.zzgwp.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzgwp.cancel(false);
        } else {
            this.zzgwp.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final boolean b() {
        return this.zzgwp.isDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        try {
            this.zzgwn.execute(this);
        } catch (RejectedExecutionException e) {
            if (this.a) {
                this.zzgwp.setException(e);
            }
        }
    }
}
