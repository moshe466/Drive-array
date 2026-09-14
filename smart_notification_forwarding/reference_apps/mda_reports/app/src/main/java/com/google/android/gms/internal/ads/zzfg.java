package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfg extends zzfw {
    private static final Object zzzs = new Object();
    private static volatile Long zzzu;

    public zzfg(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (zzzu == null) {
            synchronized (zzzs) {
                if (zzzu == null) {
                    zzzu = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.zzav(zzzu.longValue());
        }
    }
}
