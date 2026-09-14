package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzcgn extends zzcgk {
    private int zzfvv = zzcgq.zzfvw;

    public zzcgn(Context context) {
        this.f = new zzaps(context, com.google.android.gms.ads.internal.zzq.zzle().zzxb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        zzazl<InputStream> zzazlVar;
        zzcgr zzcgrVar;
        synchronized (this.b) {
            if (!this.d) {
                this.d = true;
                try {
                    if (this.zzfvv == zzcgq.zzfvx) {
                        this.f.zztx().zzc(this.e, new zzcgj(this));
                    } else if (this.zzfvv == zzcgq.zzfvy) {
                        this.f.zztx().zza((String) null, new zzcgj(this));
                    } else {
                        this.a.setException(new zzcgr(0));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzazlVar = this.a;
                    zzcgrVar = new zzcgr(0);
                    zzazlVar.setException(zzcgrVar);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzq.zzku().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
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
}
