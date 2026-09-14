package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzavo {
    private volatile Thread thread;
    private final Runnable zzdro = new zzavr(this);
    private boolean zzdrp = false;

    public abstract void zztu();

    public final zzdhe<?> zzvr() {
        return zzazd.zzdwf.zzf(this.zzdro);
    }
}
