package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzazi<T> extends zzazl<T> {
    private final T zzdwn;

    private zzazi(T t) {
        this.zzdwn = t;
    }

    public static <T> zzazi<T> zzl(T t) {
        return new zzazi<>(t);
    }

    public final void zzxn() {
        set(this.zzdwn);
    }
}
