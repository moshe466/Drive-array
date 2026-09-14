package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzaan.zzi("gad:dynamite_module:experiment_id", ""));
        zza(arrayList, zzaba.zzctk);
        zza(arrayList, zzaba.zzctl);
        zza(arrayList, zzaba.zzctm);
        zza(arrayList, zzaba.zzctn);
        zza(arrayList, zzaba.zzcto);
        zza(arrayList, zzaba.zzctu);
        zza(arrayList, zzaba.zzctp);
        zza(arrayList, zzaba.zzctq);
        zza(arrayList, zzaba.zzctr);
        zza(arrayList, zzaba.zzcts);
        zza(arrayList, zzaba.zzctt);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzabk.zzcut);
        return arrayList;
    }

    private static void zza(List<String> list, zzaan<String> zzaanVar) {
        String str = zzaanVar.get();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        list.add(str);
    }
}
