package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;
import s2.C0679d;
import t2.u;

/* loaded from: classes.dex */
public final class zzjb {
    public static final Map zza() {
        C0679d[] c0679dArr = {new C0679d(-4, zzba.zzo), new C0679d(-12, zzba.zzp), new C0679d(-6, zzba.zzk), new C0679d(-11, zzba.zzm), new C0679d(-13, zzba.zzq), new C0679d(-14, zzba.zzr), new C0679d(-2, zzba.zzl), new C0679d(-7, zzba.zzs), new C0679d(-5, zzba.zzt), new C0679d(-9, zzba.zzu), new C0679d(-8, zzba.zzE), new C0679d(-15, zzba.zzn), new C0679d(-1, zzba.zzv), new C0679d(-3, zzba.zzx), new C0679d(-10, zzba.zzy)};
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.F(15));
        u.H(linkedHashMap, c0679dArr);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            linkedHashMap.put(-16, zzba.zzw);
        }
        if (i >= 27) {
            linkedHashMap.put(1, zzba.zzA);
            linkedHashMap.put(2, zzba.zzB);
            linkedHashMap.put(0, zzba.zzC);
            linkedHashMap.put(3, zzba.zzD);
        }
        if (i >= 29) {
            linkedHashMap.put(4, zzba.zzz);
        }
        return linkedHashMap;
    }
}
