package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: classes.dex */
public class zzbkn {
    private final View view;
    private final zzbdi zzcza;
    private final zzczk zzfdo;
    private final zzbme zzfdz;

    public zzbkn(View view, @Nullable zzbdi zzbdiVar, zzbme zzbmeVar, zzczk zzczkVar) {
        this.view = view;
        this.zzcza = zzbdiVar;
        this.zzfdz = zzbmeVar;
        this.zzfdo = zzczkVar;
    }

    public zzbpw zza(Set<zzbsu<zzbqb>> set) {
        return new zzbpw(set);
    }

    @Nullable
    public final zzbdi zzaft() {
        return this.zzcza;
    }

    public final View zzaga() {
        return this.view;
    }

    public final zzbme zzagh() {
        return this.zzfdz;
    }

    public final zzczk zzagi() {
        return this.zzfdo;
    }
}
