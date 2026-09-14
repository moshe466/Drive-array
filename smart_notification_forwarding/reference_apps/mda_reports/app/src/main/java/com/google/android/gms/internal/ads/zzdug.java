package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdug extends zzdum {
    private final /* synthetic */ zzdub zzhqw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzdug(zzdub zzdubVar) {
        super(zzdubVar, null);
        this.zzhqw = zzdubVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdug(zzdub zzdubVar, zzdue zzdueVar) {
        this(zzdubVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdum, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzdud(this.zzhqw, null);
    }
}
