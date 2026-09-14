package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class zzpn implements Iterable {
    private final /* synthetic */ List zza;
    private final /* synthetic */ List zzb;

    public zzpn(zzpo zzpoVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzpp(this.zza.iterator(), this.zzb.iterator());
    }
}
