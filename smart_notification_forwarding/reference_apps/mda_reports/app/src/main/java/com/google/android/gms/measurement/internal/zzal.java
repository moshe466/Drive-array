package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzal implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzam zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzam zzamVar) {
        Bundle bundle;
        this.zzb = zzamVar;
        bundle = this.zzb.zza;
        this.zza = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
