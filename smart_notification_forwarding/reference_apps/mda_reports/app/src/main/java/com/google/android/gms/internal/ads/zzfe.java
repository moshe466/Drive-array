package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbs;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzfe extends zzfw {
    public zzfe(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 24);
    }

    private final void zzcq() {
        AdvertisingIdClient zzcj = this.a.zzcj();
        if (zzcj == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzcj.getInfo();
            String zzat = zzep.zzat(info.getId());
            if (zzat != null) {
                synchronized (this.b) {
                    this.b.zzan(zzat);
                    this.b.zzb(info.isLimitAdTrackingEnabled());
                    this.b.zzb(zzbs.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (this.a.zzcb()) {
            zzcq();
            return;
        }
        synchronized (this.b) {
            this.b.zzan((String) this.c.invoke(null, this.a.getContext()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfw, java.util.concurrent.Callable
    /* renamed from: zzcp */
    public final Void call() {
        if (this.a.isInitialized()) {
            return super.call();
        }
        if (!this.a.zzcb()) {
            return null;
        }
        zzcq();
        return null;
    }
}
