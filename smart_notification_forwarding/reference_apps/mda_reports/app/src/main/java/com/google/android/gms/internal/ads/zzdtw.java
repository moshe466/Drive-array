package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdtw extends zzdql {
    private final zzdty zzhqb;
    private zzdqp zzhqc = zzbbq();
    private final /* synthetic */ zzdtt zzhqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtw(zzdtt zzdttVar) {
        this.zzhqd = zzdttVar;
        this.zzhqb = new zzdty(this.zzhqd, null);
    }

    private final zzdqp zzbbq() {
        if (this.zzhqb.hasNext()) {
            return (zzdqp) ((zzdqr) this.zzhqb.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzhqc != null;
    }

    @Override // com.google.android.gms.internal.ads.zzdqp
    public final byte nextByte() {
        zzdqp zzdqpVar = this.zzhqc;
        if (zzdqpVar == null) {
            throw new NoSuchElementException();
        }
        byte nextByte = zzdqpVar.nextByte();
        if (!this.zzhqc.hasNext()) {
            this.zzhqc = zzbbq();
        }
        return nextByte;
    }
}
