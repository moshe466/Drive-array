package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzduv implements Iterator<String> {
    private Iterator<String> zzhrg;
    private final /* synthetic */ zzdut zzhrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduv(zzdut zzdutVar) {
        zzdsl zzdslVar;
        this.zzhrh = zzdutVar;
        zzdslVar = this.zzhrh.zzhrf;
        this.zzhrg = zzdslVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzhrg.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzhrg.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
