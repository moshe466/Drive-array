package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class zzdty implements Iterator<zzdqr> {
    private final ArrayDeque<zzdtt> zzhqj;
    private zzdqr zzhqk;

    private zzdty(zzdqk zzdqkVar) {
        zzdqr zzdqrVar;
        zzdqk zzdqkVar2;
        if (zzdqkVar instanceof zzdtt) {
            zzdtt zzdttVar = (zzdtt) zzdqkVar;
            this.zzhqj = new ArrayDeque<>(zzdttVar.a());
            this.zzhqj.push(zzdttVar);
            zzdqkVar2 = zzdttVar.zzhpw;
            zzdqrVar = zzbi(zzdqkVar2);
        } else {
            this.zzhqj = null;
            zzdqrVar = (zzdqr) zzdqkVar;
        }
        this.zzhqk = zzdqrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdty(zzdqk zzdqkVar, zzdtw zzdtwVar) {
        this(zzdqkVar);
    }

    private final zzdqr zzbi(zzdqk zzdqkVar) {
        while (zzdqkVar instanceof zzdtt) {
            zzdtt zzdttVar = (zzdtt) zzdqkVar;
            this.zzhqj.push(zzdttVar);
            zzdqkVar = zzdttVar.zzhpw;
        }
        return (zzdqr) zzdqkVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzhqk != null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzdqr next() {
        zzdqr zzdqrVar;
        zzdqk zzdqkVar;
        zzdqr zzdqrVar2 = this.zzhqk;
        if (zzdqrVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque<zzdtt> arrayDeque = this.zzhqj;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                zzdqrVar = null;
                break;
            }
            zzdqkVar = this.zzhqj.pop().zzhpx;
            zzdqrVar = zzbi(zzdqkVar);
        } while (zzdqrVar.isEmpty());
        this.zzhqk = zzdqrVar;
        return zzdqrVar2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
