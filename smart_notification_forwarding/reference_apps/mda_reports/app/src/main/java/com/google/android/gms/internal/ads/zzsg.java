package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzsg implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzse a;
    private final /* synthetic */ zzry zzbrr;
    private final /* synthetic */ zzazl zzbrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsg(zzse zzseVar, zzry zzryVar, zzazl zzazlVar) {
        this.a = zzseVar;
        this.zzbrr = zzryVar;
        this.zzbrs = zzazlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        boolean z;
        final zzrz zzrzVar;
        obj = this.a.lock;
        synchronized (obj) {
            z = this.a.zzbrq;
            if (z) {
                return;
            }
            zzse.a(this.a, true);
            zzrzVar = this.a.zzbrd;
            if (zzrzVar == null) {
                return;
            }
            zzdhd zzdhdVar = zzazd.zzdwe;
            final zzry zzryVar = this.zzbrr;
            final zzazl zzazlVar = this.zzbrs;
            final zzdhe<?> submit = zzdhdVar.submit(new Runnable(this, zzrzVar, zzryVar, zzazlVar) { // from class: com.google.android.gms.internal.ads.zzsj
                private final zzsg zzbrw;
                private final zzrz zzbrx;
                private final zzry zzbry;
                private final zzazl zzbrz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbrw = this;
                    this.zzbrx = zzrzVar;
                    this.zzbry = zzryVar;
                    this.zzbrz = zzazlVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzsg zzsgVar = this.zzbrw;
                    zzrz zzrzVar2 = this.zzbrx;
                    zzry zzryVar2 = this.zzbry;
                    zzazl zzazlVar2 = this.zzbrz;
                    try {
                        zzrx zza = zzrzVar2.zzms().zza(zzryVar2);
                        if (!zza.zzmp()) {
                            zzazlVar2.setException(new RuntimeException("No entry contents."));
                            zzsgVar.a.disconnect();
                            return;
                        }
                        zzsl zzslVar = new zzsl(zzsgVar, zza.zzmq(), 1);
                        int read = zzslVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzslVar.unread(read);
                        zzazlVar2.set(zzslVar);
                    } catch (RemoteException | IOException e) {
                        zzayu.zzc("Unable to obtain a cache service instance.", e);
                        zzazlVar2.setException(e);
                        zzsgVar.a.disconnect();
                    }
                }
            });
            zzazl zzazlVar2 = this.zzbrs;
            final zzazl zzazlVar3 = this.zzbrs;
            zzazlVar2.addListener(new Runnable(zzazlVar3, submit) { // from class: com.google.android.gms.internal.ads.zzsi
                private final zzazl zzbru;
                private final Future zzbrv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbru = zzazlVar3;
                    this.zzbrv = submit;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzazl zzazlVar4 = this.zzbru;
                    Future future = this.zzbrv;
                    if (zzazlVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzazd.zzdwj);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
