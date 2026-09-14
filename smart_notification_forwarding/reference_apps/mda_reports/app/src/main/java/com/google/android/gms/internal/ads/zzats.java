package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzats implements zzps {
    private final Object lock;
    private String zzbqz;
    private final Context zzcgd;
    private boolean zzdpa;

    public zzats(Context context, String str) {
        this.zzcgd = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbqz = str;
        this.zzdpa = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbqz;
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final void zza(zzpt zzptVar) {
        zzam(zzptVar.zzbnq);
    }

    public final void zzam(boolean z) {
        if (com.google.android.gms.ads.internal.zzq.zzlo().zzab(this.zzcgd)) {
            synchronized (this.lock) {
                if (this.zzdpa == z) {
                    return;
                }
                this.zzdpa = z;
                if (TextUtils.isEmpty(this.zzbqz)) {
                    return;
                }
                if (this.zzdpa) {
                    com.google.android.gms.ads.internal.zzq.zzlo().zze(this.zzcgd, this.zzbqz);
                } else {
                    com.google.android.gms.ads.internal.zzq.zzlo().zzf(this.zzcgd, this.zzbqz);
                }
            }
        }
    }
}
