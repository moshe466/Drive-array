package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfq extends zzfw {
    private final zzer zzvl;
    private long zzze;

    public zzfq(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, zzer zzerVar) {
        super(zzeiVar, str, str2, zzbVar, i, 53);
        this.zzvl = zzerVar;
        if (zzerVar != null) {
            this.zzze = zzerVar.zzcl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (this.zzvl != null) {
            this.b.zzbl(((Long) this.c.invoke(null, Long.valueOf(this.zzze))).longValue());
        }
    }
}
