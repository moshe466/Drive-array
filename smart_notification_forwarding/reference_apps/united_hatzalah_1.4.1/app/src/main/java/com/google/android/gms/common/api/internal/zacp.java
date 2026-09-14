package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zacp implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zacr zab;

    public zacp(zacr zacrVar, Result result) {
        this.zaa = result;
        Objects.requireNonNull(zacrVar);
        this.zab = zacrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                zacr zacrVar = this.zab;
                zacrVar.zah().sendMessage(zacrVar.zah().obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(zacrVar.zad())).onSuccess(this.zaa)));
                threadLocal.set(Boolean.FALSE);
                zacr zacrVar2 = this.zab;
                zacr.zan(this.zaa);
                GoogleApiClient googleApiClient = (GoogleApiClient) zacrVar2.zag().get();
                if (googleApiClient != null) {
                    googleApiClient.zap(zacrVar2);
                }
            } catch (RuntimeException e4) {
                zacr zacrVar3 = this.zab;
                zacrVar3.zah().sendMessage(zacrVar3.zah().obtainMessage(1, e4));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zacr zacrVar4 = this.zab;
                zacr.zan(this.zaa);
                GoogleApiClient googleApiClient2 = (GoogleApiClient) zacrVar4.zag().get();
                if (googleApiClient2 != null) {
                    googleApiClient2.zap(zacrVar4);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zacr zacrVar5 = this.zab;
            zacr.zan(this.zaa);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) zacrVar5.zag().get();
            if (googleApiClient3 != null) {
                googleApiClient3.zap(zacrVar5);
            }
            throw th;
        }
    }
}
