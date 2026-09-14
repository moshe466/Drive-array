package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdxq<T> implements zzdxp<T> {
    private static final Object zzhzz = new Object();
    private volatile Object zzduw = zzhzz;
    private volatile zzdxp<T> zziaa;

    private zzdxq(zzdxp<T> zzdxpVar) {
        this.zziaa = zzdxpVar;
    }

    public static <P extends zzdxp<T>, T> zzdxp<T> zzan(P p) {
        return ((p instanceof zzdxq) || (p instanceof zzdxd)) ? p : new zzdxq((zzdxp) zzdxm.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final T get() {
        T t = (T) this.zzduw;
        if (t != zzhzz) {
            return t;
        }
        zzdxp<T> zzdxpVar = this.zziaa;
        if (zzdxpVar == null) {
            return (T) this.zzduw;
        }
        T t2 = zzdxpVar.get();
        this.zzduw = t2;
        this.zziaa = null;
        return t2;
    }
}
