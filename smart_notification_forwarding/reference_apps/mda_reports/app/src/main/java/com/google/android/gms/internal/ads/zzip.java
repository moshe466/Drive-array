package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzip {
    private int flags;

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i) {
        return (this.flags & i) == i;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final boolean zzga() {
        return a(Integer.MIN_VALUE);
    }

    public final boolean zzgb() {
        return a(4);
    }

    public final boolean zzgc() {
        return a(1);
    }

    public final void zzw(int i) {
        this.flags |= Integer.MIN_VALUE;
    }
}
