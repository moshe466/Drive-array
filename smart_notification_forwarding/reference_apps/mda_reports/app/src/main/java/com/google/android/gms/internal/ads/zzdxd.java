package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdxd<T> implements zzdxa<T>, zzdxp<T> {
    private static final Object zzhzz = new Object();
    private volatile Object zzduw = zzhzz;
    private volatile zzdxp<T> zziaa;

    private zzdxd(zzdxp<T> zzdxpVar) {
        this.zziaa = zzdxpVar;
    }

    public static <P extends zzdxp<T>, T> zzdxp<T> zzan(P p) {
        zzdxm.checkNotNull(p);
        return p instanceof zzdxd ? p : new zzdxd(p);
    }

    public static <P extends zzdxp<T>, T> zzdxa<T> zzao(P p) {
        return p instanceof zzdxa ? (zzdxa) p : new zzdxd((zzdxp) zzdxm.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzdxa, com.google.android.gms.internal.ads.zzdxp
    public final T get() {
        T t = (T) this.zzduw;
        if (t == zzhzz) {
            synchronized (this) {
                t = (T) this.zzduw;
                if (t == zzhzz) {
                    t = this.zziaa.get();
                    Object obj = this.zzduw;
                    if (((obj == zzhzz || (obj instanceof zzdxj)) ? false : true) && obj != t) {
                        String valueOf = String.valueOf(obj);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.zzduw = t;
                    this.zziaa = null;
                }
            }
        }
        return t;
    }
}
