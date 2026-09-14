package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzcgi extends zzcgk {
    public zzcgi(Context context) {
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
                    this.f.zztx().zza(this.e, new zzcgj(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazlVar = this.a;
                    zzcgrVar = new zzcgr(0);
                    zzazlVar.setException(zzcgrVar);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(th, "RemoteAdRequestClientTask.onConnected");
                    zzazlVar = this.a;
                    zzcgrVar = new zzcgr(0);
                    zzazlVar.setException(zzcgrVar);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgk, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzayu.zzea("Cannot connect to remote service, fallback to local instance.");
        this.a.setException(new zzcgr(0));
    }

    public final zzdhe<InputStream> zzf(zzaqk zzaqkVar) {
        synchronized (this.b) {
            if (this.c) {
                return this.a;
            }
            this.c = true;
            this.e = zzaqkVar;
            this.f.checkAvailabilityAndConnect();
            this.a.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcgh
                private final zzcgi zzfvo;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfvo = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfvo.a();
                }
            }, zzazd.zzdwj);
            return this.a;
        }
    }
}
