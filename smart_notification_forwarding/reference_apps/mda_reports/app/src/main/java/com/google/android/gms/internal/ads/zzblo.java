package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzblo extends zzbkk {
    private final Executor zzfci;
    private final zzaea zzfex;
    private final Runnable zzfey;

    public zzblo(zzbmg zzbmgVar, zzaea zzaeaVar, Runnable runnable, Executor executor) {
        super(zzbmgVar);
        this.zzfex = zzaeaVar;
        this.zzfey = runnable;
        this.zzfci = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Runnable runnable) {
        try {
            if (this.zzfex.zzm(ObjectWrapper.wrap(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final zzxb getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zza(ViewGroup viewGroup, zzuj zzujVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final zzczk zzafz() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final View zzaga() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final int zzage() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    @WorkerThread
    public final void zzagf() {
        final AtomicReference atomicReference = new AtomicReference(this.zzfey);
        final Runnable runnable = new Runnable(atomicReference) { // from class: com.google.android.gms.internal.ads.zzbln
            private final AtomicReference zzfew;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfew = atomicReference;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = (Runnable) this.zzfew.getAndSet(null);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        this.zzfci.execute(new Runnable(this, runnable) { // from class: com.google.android.gms.internal.ads.zzblq
            private final Runnable zzfau;
            private final zzblo zzfez;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfez = this;
                this.zzfau = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfez.a(this.zzfau);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zzjy() {
    }
}
