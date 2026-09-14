package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzdik<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzgxv;

    public zzdik(Class<PrimitiveT> cls) {
        this.zzgxv = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<PrimitiveT> a() {
        return this.zzgxv;
    }

    public abstract PrimitiveT zzak(KeyT keyt);
}
