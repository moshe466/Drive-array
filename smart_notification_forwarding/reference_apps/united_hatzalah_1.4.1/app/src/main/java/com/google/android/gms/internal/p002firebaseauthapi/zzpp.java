package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzpp<P> implements Iterator<P> {
    private final Iterator<P> zza;
    private final Iterator<P> zzb;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.zza.hasNext() && !this.zzb.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final P next() {
        if (this.zza.hasNext()) {
            return this.zza.next();
        }
        return this.zzb.next();
    }

    private zzpp(Iterator<P> it, Iterator<P> it2) {
        this.zza = it;
        this.zzb = it2;
    }
}
