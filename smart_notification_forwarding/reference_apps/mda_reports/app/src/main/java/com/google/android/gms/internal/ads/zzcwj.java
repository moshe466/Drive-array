package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final /* synthetic */ class zzcwj implements Callable {
    static final Callable a = new zzcwj();

    private zzcwj() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzve.zzoy().zzd(zzzn.zzchj);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzve.zzoy().zzd(zzzn.zzchk)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzayi.zzer(str2));
                }
            }
        }
        return new zzcwh(hashMap);
    }
}
