package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzjo implements Iterator {
    boolean zza = true;
    final /* synthetic */ Iterator zzb;

    public zzjo(zzjp zzjpVar, Iterator it) {
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzjf.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
