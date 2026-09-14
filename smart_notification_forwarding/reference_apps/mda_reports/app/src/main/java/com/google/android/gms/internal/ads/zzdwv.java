package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
final class zzdwv<E> implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzdww zzhzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwv(zzdww zzdwwVar) {
        this.zzhzm = zzdwwVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos < this.zzhzm.a.size() || this.zzhzm.b.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zzhzm.a.size()) {
            zzdww zzdwwVar = this.zzhzm;
            zzdwwVar.a.add(zzdwwVar.b.next());
        }
        List<E> list = this.zzhzm.a;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
