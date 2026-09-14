package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfp extends zzfw {
    private static volatile Long zzaaa;
    private static final Object zzzs = new Object();

    public zzfp(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 33);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (zzaaa == null) {
            synchronized (zzzs) {
                if (zzaaa == null) {
                    zzaaa = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.zzaz(zzaaa.longValue());
        }
    }
}
