package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfc extends zzfw {
    private static volatile Long zzzr;
    private static final Object zzzs = new Object();

    public zzfc(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 44);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (zzzr == null) {
            synchronized (zzzs) {
                if (zzzr == null) {
                    zzzr = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.zzbh(zzzr.longValue());
        }
    }
}
