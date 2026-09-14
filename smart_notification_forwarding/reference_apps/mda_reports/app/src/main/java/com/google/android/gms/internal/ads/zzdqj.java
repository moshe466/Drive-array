package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdqj extends zzdql {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzdqk zzhhw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqj(zzdqk zzdqkVar) {
        this.zzhhw = zzdqkVar;
        this.limit = this.zzhhw.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzdqp
    public final byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.zzhhw.a(i);
    }
}
