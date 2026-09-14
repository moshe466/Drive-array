package com.google.android.recaptcha.internal;

import kotlinx.coroutines.TimeoutCancellationException;

/* loaded from: classes.dex */
public final class zzf {
    public static final zzbd zza(Exception exc, zzbd zzbdVar) {
        if (exc instanceof TimeoutCancellationException) {
            return new zzbd(zzbb.zzb, zzba.zzb, exc.getMessage());
        }
        if (exc instanceof zzbd) {
            return (zzbd) exc;
        }
        return zzbdVar;
    }
}
