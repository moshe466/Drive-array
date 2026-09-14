package com.google.android.recaptcha.internal;

import F2.a;
import android.app.Application;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class zziw extends k implements a {
    public static final zziw zza = new zziw();

    public zziw() {
        super(0);
    }

    @Override // F2.a
    public final Object invoke() {
        int i = zzav.zza;
        Object zzb = zzau.zza().zzb(735120228);
        if (zzb != null) {
            return (Application) zzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
