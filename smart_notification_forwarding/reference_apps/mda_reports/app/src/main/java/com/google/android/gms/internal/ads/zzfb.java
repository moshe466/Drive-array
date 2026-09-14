package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfb extends zzfw {
    private long startTime;

    public zzfb(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, long j, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.zzbr(longValue);
            if (this.startTime != 0) {
                this.b.zzat(longValue - this.startTime);
                this.b.zzaw(this.startTime);
            }
        }
    }
}
