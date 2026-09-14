package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzej extends zzcj<Integer, Long> {
    public Long zzya;
    public Long zzyb;

    public zzej() {
    }

    public zzej(String str) {
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzya);
        hashMap.put(1, this.zzyb);
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            this.zzya = (Long) a.get(0);
            this.zzyb = (Long) a.get(1);
        }
    }
}
