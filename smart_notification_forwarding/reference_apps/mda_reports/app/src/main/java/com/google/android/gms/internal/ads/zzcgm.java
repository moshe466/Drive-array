package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzcgm extends zzcgk {
    public zzcgm(Context context) {
        this.f = new zzaps(context, com.google.android.gms.ads.internal.zzq.zzle().zzxb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzazl<InputStream> zzazlVar;
        zzcgr zzcgrVar;
        synchronized (this.b) {
            if (!this.d) {
                this.d = true;
                try {
                    this.f.zztx().zzb(this.e, new zzcgj(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazlVar = this.a;
                    zzcgrVar = new zzcgr(0);
                    zzazlVar.setException(zzcgrVar);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(th, "RemoteSignalsClientTask.onConnected");
                    zzazlVar = this.a;
                    zzcgrVar = new zzcgr(0);
                    zzazlVar.setException(zzcgrVar);
                }
            }
        }
    }

    public final zzdhe<InputStream> zzg(zzaqk zzaqkVar) {
        synchronized (this.b) {
            if (this.c) {
                return this.a;
            }
            this.c = true;
            this.e = zzaqkVar;
            this.f.checkAvailabilityAndConnect();
            this.a.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcgl
                private final zzcgm zzfvu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfvu = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfvu.a();
                }
            }, zzazd.zzdwj);
            return this.a;
        }
    }
}
