package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbjw {
    private final View view;
    private final zzbdi zzcza;
    private final zzczk zzfdo;
    private final int zzfdp;

    public zzbjw(View view, @Nullable zzbdi zzbdiVar, zzczk zzczkVar, int i) {
        this.view = view;
        this.zzcza = zzbdiVar;
        this.zzfdo = zzczkVar;
        this.zzfdp = i;
    }

    @Nullable
    public final zzbdi zzaft() {
        return this.zzcza;
    }

    public final View zzafu() {
        return this.view;
    }

    public final zzczk zzafv() {
        return this.zzfdo;
    }

    public final int zzafw() {
        return this.zzfdp;
    }
}
