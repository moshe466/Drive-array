package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzzw {
    public static void zza(zzzu zzzuVar, @Nullable zzzr zzzrVar) {
        if (zzzrVar.a() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzzrVar.b())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzzuVar.zza(zzzrVar.a(), zzzrVar.b(), zzzrVar.c(), zzzrVar.d());
    }
}
