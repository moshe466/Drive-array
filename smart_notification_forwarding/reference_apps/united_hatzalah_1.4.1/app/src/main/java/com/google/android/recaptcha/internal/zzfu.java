package com.google.android.recaptcha.internal;

import N2.f;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.j;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class zzfu {
    private Set zza;
    private Set zzb;
    private Long zzc;
    private int zzd;

    private static final boolean zzc(String str, Set set) {
        Iterator it = f.a0(str, new char[]{'.'}).iterator();
        String str2 = "";
        while (it.hasNext()) {
            String concat = str2.concat(String.valueOf((String) it.next()));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(".");
        }
        return false;
    }

    public final void zza(zzrv zzrvVar) {
        this.zza = AbstractC0707i.u0(zzrvVar.zzf().zzi());
        this.zzb = AbstractC0707i.u0(zzrvVar.zzg().zzi());
    }

    public final boolean zzb(String str) {
        Set set = this.zza;
        if (set != null && this.zzb != null) {
            if (set.isEmpty()) {
                return true;
            }
            Set set2 = this.zzb;
            j.c(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            if (zzc(str, set2)) {
                return false;
            }
            return zzc(str, set);
        }
        if (this.zzc == null) {
            this.zzc = Long.valueOf(System.currentTimeMillis());
        }
        this.zzd++;
        return true;
    }
}
