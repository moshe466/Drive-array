package com.google.android.recaptcha.internal;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbc {
    public static final zzbd zza(zztv zztvVar) {
        Map map;
        map = zzbd.zzb;
        zzbd zzbdVar = (zzbd) map.get(zztvVar);
        if (zzbdVar == null) {
            return new zzbd(zzbb.zza, zzba.zzaq, null);
        }
        return zzbdVar;
    }
}
