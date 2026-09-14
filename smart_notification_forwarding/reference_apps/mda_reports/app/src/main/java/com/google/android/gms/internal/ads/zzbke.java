package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbke extends zzbmd {
    private final View view;

    @Nullable
    private final zzbdi zzcza;
    private final zzczk zzfdo;
    private final int zzfdp;

    @Nullable
    private zzrl zzfdt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbke(zzbmg zzbmgVar, View view, @Nullable zzbdi zzbdiVar, zzczk zzczkVar, int i) {
        super(zzbmgVar);
        this.view = view;
        this.zzcza = zzbdiVar;
        this.zzfdo = zzczkVar;
        this.zzfdp = i;
    }

    public final void zza(zzra zzraVar) {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar != null) {
            zzbdiVar.zza(zzraVar);
        }
    }

    public final void zza(zzrl zzrlVar) {
        this.zzfdt = zzrlVar;
    }

    public final boolean zzaat() {
        zzbdi zzbdiVar = this.zzcza;
        return (zzbdiVar == null || zzbdiVar.zzaaa() == null || !this.zzcza.zzaaa().zzaat()) ? false : true;
    }

    public final int zzafw() {
        return this.zzfdp;
    }

    public final zzczk zzafz() {
        return zzczy.zza(this.b.zzgln, this.zzfdo);
    }

    public final View zzaga() {
        return this.view;
    }

    public final boolean zzagb() {
        zzbdi zzbdiVar = this.zzcza;
        return zzbdiVar != null && zzbdiVar.zzaac();
    }

    @Nullable
    public final zzrl zzagc() {
        return this.zzfdt;
    }
}
