package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzes extends zzcj<Integer, Long> {
    public Long zzzf;
    public Long zzzg;
    public Long zzzh;
    public Long zzzi;

    public zzes() {
    }

    public zzes(String str) {
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzzf);
        hashMap.put(1, this.zzzg);
        hashMap.put(2, this.zzzh);
        hashMap.put(3, this.zzzi);
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            this.zzzf = (Long) a.get(0);
            this.zzzg = (Long) a.get(1);
            this.zzzh = (Long) a.get(2);
            this.zzzi = (Long) a.get(3);
        }
    }
}
