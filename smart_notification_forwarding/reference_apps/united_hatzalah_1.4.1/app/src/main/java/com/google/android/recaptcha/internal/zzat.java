package com.google.android.recaptcha.internal;

import F2.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import t2.u;

/* loaded from: classes.dex */
final class zzat extends k implements a {
    public static final zzat zza = new zzat();

    public zzat() {
        super(0);
    }

    public static final Map zza() {
        Map map;
        map = zzav.zzc;
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.F(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((zzaw) entry.getValue()).zzb());
        }
        return linkedHashMap;
    }

    @Override // F2.a
    public final /* bridge */ /* synthetic */ Object invoke() {
        return zza();
    }
}
