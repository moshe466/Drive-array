package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzeg extends zzcj<Integer, Object> {
    public Long zzxh;
    public Boolean zzxi;
    public Boolean zzxj;

    public zzeg() {
    }

    public zzeg(String str) {
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzxh);
        hashMap.put(1, this.zzxi);
        hashMap.put(2, this.zzxj);
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            this.zzxh = (Long) a.get(0);
            this.zzxi = (Boolean) a.get(1);
            this.zzxj = (Boolean) a.get(2);
        }
    }
}
