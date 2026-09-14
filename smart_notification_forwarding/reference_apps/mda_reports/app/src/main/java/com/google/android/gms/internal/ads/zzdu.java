package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzdu extends zzcj<Integer, Long> {
    public long zzwx;
    public long zzwy;

    public zzdu() {
        this.zzwx = -1L;
        this.zzwy = -1L;
    }

    public zzdu(String str) {
        this();
        b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcj
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzwx));
        hashMap.put(1, Long.valueOf(this.zzwy));
        return hashMap;
    }

    protected final void b(String str) {
        HashMap a = zzcj.a(str);
        if (a != null) {
            this.zzwx = ((Long) a.get(0)).longValue();
            this.zzwy = ((Long) a.get(1)).longValue();
        }
    }
}
