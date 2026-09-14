package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzeq extends zzcj<Integer, Long> {
    public Long zzyj;
    public Long zzyk;
    public Long zzyl;
    public Long zzym;
    public Long zzyn;
    public Long zzyo;
    public Long zzyp;
    public Long zzyq;
    public Long zzyr;
    public Long zzys;
    public Long zzyt;

    public zzeq() {
    }

    public zzeq(String str) {
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyj);
        hashMap.put(1, this.zzyk);
        hashMap.put(2, this.zzyl);
        hashMap.put(3, this.zzym);
        hashMap.put(4, this.zzyn);
        hashMap.put(5, this.zzyo);
        hashMap.put(6, this.zzyp);
        hashMap.put(7, this.zzyq);
        hashMap.put(8, this.zzyr);
        hashMap.put(9, this.zzys);
        hashMap.put(10, this.zzyt);
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            this.zzyj = (Long) a.get(0);
            this.zzyk = (Long) a.get(1);
            this.zzyl = (Long) a.get(2);
            this.zzym = (Long) a.get(3);
            this.zzyn = (Long) a.get(4);
            this.zzyo = (Long) a.get(5);
            this.zzyp = (Long) a.get(6);
            this.zzyq = (Long) a.get(7);
            this.zzyr = (Long) a.get(8);
            this.zzys = (Long) a.get(9);
            this.zzyt = (Long) a.get(10);
        }
    }
}
