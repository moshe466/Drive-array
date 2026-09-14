package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final class zzcht {
    private final zzchr zzfwu;
    private final zzdhd zzfwv;

    public zzcht(zzchr zzchrVar, zzdhd zzdhdVar) {
        this.zzfwu = zzchrVar;
        this.zzfwv = zzdhdVar;
    }

    public final void zza(zzdby<SQLiteDatabase, Void> zzdbyVar) {
        zzdhd zzdhdVar = this.zzfwv;
        zzchr zzchrVar = this.zzfwu;
        zzchrVar.getClass();
        zzdgs.zza(zzdhdVar.submit(zzchw.a(zzchrVar)), new zzchv(this, zzdbyVar), this.zzfwv);
    }
}
